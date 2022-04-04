/**
 * @author Adam Tucker
 */


USE cafeDB;

INSERT INTO menu(item, description, category, price)
VALUES ('Margherita pizza', 'cheese pizza with tomato sauce and mozzarella', 'food', 08.45),
       ('Cheese burger', 'beef burger with cheese in a brioche bun', 'food', 10.50),
       ('Spaghetti carbonara', 'spaghetti with pancetta coated in a peppery egg yolk and parmesan sauce', 'food',
        14.75),
       ('Mango lassi', 'a sweet and thick mango flavoured yoghurt drink', 'drink', 3.00),
       ('Fosters',
        'a refreshing water like beverage with a delicate hint of beer, please refrain from striking others after consumption',
        'special', 2.50),
       ('Cafe94 kebab',
        '94 different meats in one giant kebab served with salad in a 1ft pita bread, if you can finish it in under 15 minutes it''s free!',
        'food', 40.00),
       ('Tap water', 'ask your server for tap water, it''s free', 'drink', 00.00),
       ('Lilt', 'tropical carbonated fruit drink', 'drink', 1.50),
       ('CocaCola', 'the one that isn''t pepsi', 'drink', 1.60),
       ('Fanta', 'orange flavoured carbonated drink', 'drink', 1.50),
       ('Gateau St. Honoré',
        'A layered desert made from a combination of different pastries, and a mixture of crème pâtissière and italian meringue known as Chiboust cream, please request this desert at the time of reservation as it takes hours to prepare',
        'special', 60.00);

INSERT INTO users
    (f_name, l_name, role, username, password, house_number, postcode)
VALUES ('adam', 'tucker', 'manager', 'atucker', 'atucker1', '1', 'ABC123'),
       ('cameron', 'turner', 'waiter', 'cturner', 'cturner1', '1', 'ABC123'),
       ('chris', 'griffiths', 'chef', 'cgriffiths', 'cgriffiths1', '1', 'ABC123'),
       ('jeremy', 'yong', 'driver', 'jyong', 'jyong1', '1', 'ABC123'),
       ('chunming', 'peng', 'customer', 'cpeng', 'cpeng1', '1', 'ABC123'),
       ('chenyu', 'tao', 'customer', 'ctao', 'ctao1', '1', 'ABC123');

DROP PROCEDURE IF EXISTS fill_cap;

DELIMITER //
CREATE PROCEDURE fill_cap(start_date DATE, end_date DATE, start_table INT,
                          start_seat INT, start_hour TIME)
BEGIN
    WHILE start_date <= end_date
        DO
            SET start_table = 1;
            SET start_seat = 2;
            WHILE start_table <= 11
                DO
                    SET start_hour = 1200;
                    WHILE start_hour <= 2200
                        DO
                            INSERT INTO capacity (table_number, seats, date, hour)
                            VALUES (start_table, start_seat, start_date, start_hour);
                            SET start_hour = start_hour + 100;
                        END WHILE;
                    SET start_table = start_table + 1;
                    IF start_table = 1 OR start_table = 2 OR start_table = 3 OR start_table = 4 THEN
                        BEGIN
                            SET start_seat = 2;
                        END;
                    END IF;
                    IF start_table = 5 OR start_table = 6 OR start_table = 7 OR start_table = 8 THEN
                        BEGIN
                            SET start_seat = 4;
                        END;
                    END IF;
                    IF start_table = 9 OR start_table = 10 THEN
                        BEGIN
                            SET start_seat = 8;
                        END;
                    END IF;
                    IF start_table = 11 THEN
                        BEGIN
                            SET start_seat = 10;
                        END;
                    END IF;
                END WHILE;
            SET start_date = DATE_ADD(start_date, INTERVAL 1 day);
        END WHILE;
END //
DELIMITER ;

CALL fill_cap(CURRENT_DATE, '2022-12-31', 1, 2, 1200);

INSERT INTO bookings
    (b_user_ID, b_cap_ID, guests)
VALUES (5, 4045, 4),  # we will need to actually show the user a list of every hour that
       # is available for their number of guests and chosen date
       # when they select an hour, it should choose the top most table
       # where seats >= guests from the cap table where
       # date = inputDate (GUI), hour = inputHour (GUI), seats >= inputGuests (GUI)
       # then we just input a new booking into the table,
       # we don't need to worry about double bookings because cap_ID is unique
       (5, 3994, 2),
       (6, 4104, 10),
       (5, 4205, 8),
       (6, 4216, 6),
##(       ,       ,      40), NOT POSSIBLE, so we instead break up the booking into allocating guests
       ## by creating an entry for the highest cap table first at that time, then the next highest.. etc
       (6, 4473, 10), #10 so far
       (6, 4462, 8),  # 18
       (6, 4451, 8),  # 26
       (6, 4440, 4),  # 30           THIS IS ALL THE SAME REAL WORLD BOOKING
       (6, 4429, 4),  # 34           so we need to group these bookings, by checking that the cust ID is the same
       (6, 4418, 4),  # 38           and that the date AND hour are the same for all cap_ID
       (6, 4396, 2);
# 40   WE WILL NEED AN ALGORITHM TO FIND ALL AVAILABLE COMBINATIONS OF TABLES
## FOR A GIVEN NUMBER OF GUESTS WHEN GUESTS > 10

/*
 this algorithm should work as following:
 *to get the next 30 days availability for any amount of 10 <= guests <= 76*
 set remainingGuestsToAllocate = inputGuests
 for each date starting from the next date, and ending on the 30th date from now:
    find every hour where the large table (table 11) is available,
    for each of these hours,
    set remainingGuestsToAllocate = remainingGuestsToAllocate - 10
    DO THIS UNTIL remainGUESTS < 0
        check the capID that is 11 less, if its available, remainingGuestsToAllocate - 8,
        check the capID that is 11 less, if its available, remainingGuestsToAllocate - 8,
        check the capID that is 11 less, if its available, remainingGuestsToAllocate - 4,
        check the capID that is 11 less, if its available, remainingGuestsToAllocate - 4,
        check the capID that is 11 less, if its available, remainingGuestsToAllocate - 4,
        check the capID that is 11 less, if its available, remainingGuestsToAllocate - 4,
        check the capID that is 11 less, if its available, remainingGuestsToAllocate - 2,
        check the capID that is 11 less, if its available, remainingGuestsToAllocate - 2,
        check the capID that is 11 less, if its available, remainingGuestsToAllocate - 2,
        check the capID that is 11 less, if its available, remainingGuestsToAllocate - 2,


 */



DROP PROCEDURE IF EXISTS remove_old_bookings;

DELIMITER //
CREATE PROCEDURE remove_old_bookings(today DATE)
BEGIN
    DELETE FROM capacity WHERE date <= today;
END //
DELIMITER ;

#####CALL remove_current_availability(CURRENT_DATE); #FOR REMOVING ALL PREVIOUS BOOKING DATA


INSERT INTO orders
    (FK_user_ID, type, item_list, date_time, table_number, prepared)
VALUES (2, 'seated',
        'Margherita pizza,Cheese burger,Spaghetti carbonara,Mango lassi,Fosters,Cafe94 kebab,Tap water,Lilt,CocaCola,Fanta,Gateau St. Honoré,',
        CURRENT_TIMESTAMP, 11, 0),
       (2, 'seated',
        'Cheese burger,Tap water,',
        CURRENT_TIMESTAMP, 1, 1),
       (2, 'seated',
        'Fanta,Spaghetti carbonara,Cafe94 kebab,',
        CURRENT_TIMESTAMP, 6, 1),
       (6, 'delivery',
        'Fanta,Spaghetti carbonara,Cafe94 kebab,',
        CURRENT_TIMESTAMP, null, 1),
       (6, 'delivery',
        'Fanta,Spaghetti carbonara,Cafe94 kebab,',
        CURRENT_TIMESTAMP, null, 1),
       (5, 'takeaway',
        'Fanta,Spaghetti carbonara,Cafe94 kebab,',
        CURRENT_TIMESTAMP, null, 0),
       (5, 'takeaway',
        'Fanta,Spaghetti carbonara,Cafe94 kebab,',
        CURRENT_TIMESTAMP, null, 0),
       (5, 'takeaway',
        'Fanta,Spaghetti carbonara,Cafe94 kebab,',
        CURRENT_TIMESTAMP, null, 1);
