/*
DONT HAVE TO IMPLEMENT
restaurant availability,
staff cover,
events
*/
DROP DATABASE IF EXISTS cafeDB;
CREATE DATABASE cafeDB;

USE cafeDB;

DROP TABLE IF EXISTS menu;

CREATE TABLE menu (
    menu_ID SERIAL, ## primary key
    item VARCHAR(50) UNIQUE, ## could use this as the primary key but then it's slow
    ## because of string comparisons rather than int comparisons
    description LONGTEXT NOT NULL UNIQUE, ##longtext for wordy descriptions above 255 char
    food_flag BOOLEAN default false, ## one of these must be true due to constraint
    drink_flag BOOLEAN default false, ## it isn't a menu item is it isn't food or drink
    special_flag BOOLEAN default false, ## if the item is a special, can use to show
    ## the current specials and quickly delete old ones or new ones
    ## in java we could do something where the price is set to null,
    ## and as a result, we do a delete query to delete all specials with null price
    ## easy way to update specials to only keep current ones on the menu
    price DECIMAL(4,2) DEFAULT NULL, ## if null then the item is not available to order
    CONSTRAINT pk_menu PRIMARY KEY (menu_ID),
    CONSTRAINT food_or_drink CHECK (food_flag = 1 XOR drink_flag = 1)
    ## XOR because it must be either food or drink, not both
);

INSERT INTO
    menu(item, description, food_flag, drink_flag, special_flag, price)
VALUES
    ('Margherita pizza', 'cheese pizza with tomato sauce and mozzarella', 1, 0, 0, 08.45),
    ('Cheese burger', 'beef burger with cheese in a brioche bun', 1, 0, 0, 10.50),
    ('Spaghetti carbonara', 'spaghetti with pancetta coated in a peppery egg yolk and parmesan sauce', 1, 0, 1, 14.75),
    ('Mango lassi', 'a sweet and thick mango flavoured yoghurt drink', 0, 1, 0, 3.00),
    ('Fosters', 'a refreshing water like beverage with a delicate hint of beer, please refrain from striking others after consumption', 0, 1, 0, 2.50),
    ('Cafe94 kebab', '94 different meats in one giant kebab served with salad in a 1ft pita bread, if you can finish it in under 15 minutes it''s free!', 1, 0, 0, 40.00),
    ('Tap water', 'ask your server for tap water, it''s free', 0, 1, 0, 00.00),
    ('Lilt', 'tropical carbonated fruit drink', 0, 1, 0, 1.50),
    ('CocaCola', 'the one that isn''t pepsi', 0, 1, 0, 1.60),
    ('Fanta', 'orange flavoured carbonated drink', 0, 1, 0, 1.50),
    ('Gateau St. Honoré', 'A layered desert made from a combination of different pastries, and a mixture of crème pâtissière and italian meringue known as Chiboust cream, please request this desert at the time of reservation as it takes hours to prepare', 1, 0, 1, 60.00);


DROP TABLE IF EXISTS users;

 CREATE TABLE users (
     user_ID      BIGINT AUTO_INCREMENT,
     f_name       VARCHAR(50),
     l_name       VARCHAR(50),
     role         VARCHAR(50) NOT NULL,
     username     VARCHAR(16) NOT NULL,
     password     VARCHAR(16) NOT NULL,
     house_number VARCHAR(10) NOT NULL,
     postcode     VARCHAR(8)  NOT NULL,
     CONSTRAINT role_enum CHECK (role = 'customer' OR role = 'waiter' OR role = 'manager' OR
                                 role = 'driver' OR role = 'chef'),
     CONSTRAINT unique_user UNIQUE (username),
     CONSTRAINT pk_users PRIMARY KEY (user_ID, role)
 );

INSERT INTO users
    (f_name, l_name, role, username, password, house_number, postcode)
VALUES
    ('adam','tucker','manager','atucker','atucker1','1','ABC123'),
    ('cameron','turner','waiter','cturner','cturner1','1','ABC123'),
    ('chris','griffiths','chef','cgriffiths','cgriffiths1','1','ABC123'),
    ('jeremy','yong','driver','jyong','jyong1','1','ABC123'),
    ('chunming','peng','customer','cpeng','cpeng1','1','ABC123'),
    ('chenyu','tao','customer','ctao','ctao1','1','ABC123');


DROP TABLE IF EXISTS capacity;

CREATE TABLE capacity (
    cap_ID BIGINT AUTO_INCREMENT,
    table_number INT NOT NULL,
    seats INT NOT NULL,
    is_available BOOLEAN DEFAULT TRUE NOT NULL,
    CONSTRAINT pk_cap PRIMARY KEY (cap_ID, table_number),
    CONSTRAINT table_range CHECK (table_number > 0 AND table_number < 12),
    CONSTRAINT seats_range CHECK (seats = 2 OR seats = 4 OR seats = 8 OR seats = 10),
    date DATE NOT NULL,
    hour INT NOT NULL
);

DROP TABLE IF EXISTS bookings;

CREATE TABLE bookings (
    booking_ID BIGINT AUTO_INCREMENT,
    b_user_ID BIGINT,
    b_cap_ID BIGINT UNIQUE,
    guests INT NOT NULL,
    FOREIGN KEY (b_user_ID) REFERENCES users(user_ID),
    FOREIGN KEY (b_cap_ID) REFERENCES capacity(cap_ID),
    CONSTRAINT pk_bookings PRIMARY KEY (booking_ID, b_user_ID, b_cap_ID),
    CONSTRAINT max_guests CHECK (guests < 77)
);

CREATE OR REPLACE VIEW customers as
    SELECT * FROM users
    WHERE role = 'customer';

CREATE OR REPLACE VIEW staff as
    SELECT * FROM users
    WHERE role != 'customer';

INSERT INTO bookings
(b_user_ID, b_cap_ID, guests)
VALUES
(     5  ,      4045 ,      4 ), # we will need to actually show the user a list of every hour that
                                # is available for their number of guests and chosen date
                                # when they select an hour, it should choose the top most table
                                # where seats >= guests from the cap table where
                                # date = inputDate (GUI), hour = inputHour (GUI), seats >= inputGuests (GUI)
                                # then we just input a new booking into the table,
                                # we don't need to worry about double bookings because cap_ID is unique
(     5  ,      3994 ,      2 ),
(     6  ,      4104 ,      10),
(     5  ,      4205 ,      8 ),
(     6  ,      4216 ,      6 ),
##(       ,       ,      40), NOT POSSIBLE, so we instead break up the booking into allocating guests
       ## by creating an entry for the highest cap table first at that time, then the next highest.. etc
(6 , 4473, 10), #10 so far
(6 , 4462,  8), # 18
(6 , 4451,  8), # 26
(6 , 4440,  4), # 30           THIS IS ALL THE SAME REAL WORLD BOOKING
(6 , 4429,  4), # 34           so we need to group these bookings, by checking that the cust ID is the same
(6 , 4418,  4), # 38           and that the date AND hour are the same for all cap_ID
(6 , 4396,  2); # 40   WE WILL NEED AN ALGORITHM TO FIND ALL AVAILABLE COMBINATIONS OF TABLES
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
SELECT * from (
    SELECT * from bookings
    INNER JOIN capacity
    on bookings.b_cap_ID = capacity.cap_ID ) as sel1
INNER JOIN users
    ON users.user_ID = sel1.b_user_ID;



DROP PROCEDURE IF EXISTS fill_cap;

DELIMITER //
CREATE PROCEDURE fill_cap(start_date DATE, end_date DATE, start_table INT,
                                            start_seat INT, start_hour TIME)
BEGIN
    WHILE start_date <= end_date DO
        SET start_table = 1;
        SET start_seat = 2;
        WHILE start_table <= 11 DO
            SET start_hour = 1200;
            WHILE start_hour <= 2200 DO
                INSERT INTO capacity (table_number, seats, date, hour) VALUES (start_table, start_seat, start_date, start_hour);
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

CALL fill_cap('2022-03-20','2022-05-30', 1, 2, 1200);

DROP PROCEDURE IF EXISTS remove_old_bookings;

DELIMITER //
CREATE PROCEDURE remove_old_bookings(today DATE)
BEGIN
    DELETE FROM capacity WHERE date <= today;
END //
DELIMITER ;

#####CALL remove_current_availability(CURRENT_DATE); #FOR REMOVING ALL PREVIOUS BOOKING DATA

DROP TABLE IF EXISTS orders;

CREATE TABLE orders (
    order_ID BIGINT AUTO_INCREMENT,
    FK_user_ID BIGINT,
    CONSTRAINT pk_orders PRIMARY KEY (order_ID, FK_user_ID),
    type ENUM('takeaway', 'delivery', 'seated'),
    table_number INT DEFAULT NULL,
    item_list LONGTEXT NOT NULL,
    date_time DATETIME NOT NULL DEFAULT NOW(),
    prepared BOOLEAN DEFAULT FALSE,
    complete BOOLEAN DEFAULT FALSE
);

INSERT INTO orders
(FK_user_ID, type, item_list, date_time, table_number, prepared)
VALUES
(   2,   'seated',
 'Margherita pizza,Cheese burger,Spaghetti carbonara,Mango lassi,Fosters,Cafe94 kebab,Tap water,Lilt,CocaCola,Fanta,Gateau St. Honoré,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null',
 CURRENT_TIMESTAMP, 11, 0),
(   2,   'seated',
 'Cheese burger,Tap water,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null',
 CURRENT_TIMESTAMP, 1, 1),
(   2,   'seated',
 'Fanta,Spaghetti carbonara,Cafe94 kebab,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null',
 CURRENT_TIMESTAMP, 6, 1),
(   6,   'delivery',
 'Fanta,Spaghetti carbonara,Cafe94 kebab,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null',
 CURRENT_TIMESTAMP, null, 1),
(   6,   'delivery',
 'Fanta,Spaghetti carbonara,Cafe94 kebab,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null',
 CURRENT_TIMESTAMP, null, 1),
(   5,   'takeaway',
 'Fanta,Spaghetti carbonara,Cafe94 kebab,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null',
 CURRENT_TIMESTAMP, null, 0),
(   5,   'takeaway',
 'Fanta,Spaghetti carbonara,Cafe94 kebab,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null',
 CURRENT_TIMESTAMP, null, 0),
(   5,   'takeaway',
 'Fanta,Spaghetti carbonara,Cafe94 kebab,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null',
 CURRENT_TIMESTAMP, null, 1);


CREATE OR REPLACE VIEW list_orders as
SELECT *
FROM orders
    INNER JOIN users ON (orders.order_ID, orders.FK_user_ID) =
                                (orders.order_ID, users.user_ID);


CREATE OR REPLACE VIEW items_separate_orders as
SELECT order_ID, user_ID, FK_user_ID, username, password, table_number, prepared, complete,
       (SUBSTRING_INDEX(item_list, ',', 1)) AS 1st,
       (SUBSTRING_INDEX(SUBSTRING_INDEX(item_list, ',', 2), ',', -1)) AS 2nd,
       (SUBSTRING_INDEX(SUBSTRING_INDEX(item_list, ',', 3), ',', -1)) AS 3rd,
       (SUBSTRING_INDEX(SUBSTRING_INDEX(item_list, ',', 4), ',', -1)) AS 4th,
       (SUBSTRING_INDEX(SUBSTRING_INDEX(item_list, ',', 5), ',', -1)) AS 5th,
       (SUBSTRING_INDEX(SUBSTRING_INDEX(item_list, ',', 6), ',', -1)) AS 6th,
       (SUBSTRING_INDEX(SUBSTRING_INDEX(item_list, ',', 7), ',', -1)) AS 7th,
       (SUBSTRING_INDEX(SUBSTRING_INDEX(item_list, ',', 8), ',', -1)) AS 8th,
       (SUBSTRING_INDEX(SUBSTRING_INDEX(item_list, ',', 9), ',', -1)) AS 9th,
       (SUBSTRING_INDEX(SUBSTRING_INDEX(item_list, ',', 10), ',', -1)) AS 10th,
       (SUBSTRING_INDEX(SUBSTRING_INDEX(item_list, ',', 11), ',', -1)) AS 11th,
       (SUBSTRING_INDEX(SUBSTRING_INDEX(item_list, ',', 12), ',', -1)) AS 12th,
       (SUBSTRING_INDEX(SUBSTRING_INDEX(item_list, ',', 13), ',', -1)) AS 13th,
       (SUBSTRING_INDEX(SUBSTRING_INDEX(item_list, ',', 14), ',', -1)) AS 14th,
       (SUBSTRING_INDEX(SUBSTRING_INDEX(item_list, ',', 15), ',', -1)) AS 15th,
       (SUBSTRING_INDEX(SUBSTRING_INDEX(item_list, ',', 16), ',', -1)) AS 16th,
       (SUBSTRING_INDEX(SUBSTRING_INDEX(item_list, ',', 17), ',', -1)) AS 17th,
       (SUBSTRING_INDEX(SUBSTRING_INDEX(item_list, ',', 18), ',', -1)) AS 18th,
       (SUBSTRING_INDEX(SUBSTRING_INDEX(item_list, ',', 19), ',', -1)) AS 19th,
       (SUBSTRING_INDEX(SUBSTRING_INDEX(item_list, ',', 20), ',', -1)) AS 20th,
       (SUBSTRING_INDEX(SUBSTRING_INDEX(item_list, ',', 21), ',', -1)) AS 21st,
       (SUBSTRING_INDEX(SUBSTRING_INDEX(item_list, ',', 22), ',', -1)) AS 22nd,
       (SUBSTRING_INDEX(SUBSTRING_INDEX(item_list, ',', 23), ',', -1)) AS 23rd,
       (SUBSTRING_INDEX(SUBSTRING_INDEX(item_list, ',', 24), ',', -1)) AS 24th,
       (SUBSTRING_INDEX(SUBSTRING_INDEX(item_list, ',', 25), ',', -1)) AS 25th,
       (SUBSTRING_INDEX(SUBSTRING_INDEX(item_list, ',', 26), ',', -1)) AS 26th,
       (SUBSTRING_INDEX(SUBSTRING_INDEX(item_list, ',', 27), ',', -1)) AS 27th,
       (SUBSTRING_INDEX(SUBSTRING_INDEX(item_list, ',', 28), ',', -1)) AS 28th,
       (SUBSTRING_INDEX(SUBSTRING_INDEX(item_list, ',', 29), ',', -1)) AS 29th,
       (SUBSTRING_INDEX(SUBSTRING_INDEX(item_list, ',', 30), ',', -1)) AS 30th,
       type, date_time, f_name, l_name, role, house_number, postcode
FROM orders
         INNER JOIN users ON (orders.order_ID, orders.FK_user_ID) =
                             (orders.order_ID, users.user_ID);


CREATE OR REPLACE VIEW chef_view AS
    SELECT order_ID as `#`, type, prepared, date_time,
           1st,2nd,3rd,4th,5th,6th,7th,8th,9th,10th,11th,12th,13th,
           14th,15th,16th,17th,18th,19th,20th,21st,22nd,23rd,24th,25th,
           26th,27th,28th,29th,30th
    FROM items_separate_orders
    WHERE prepared = 0
    ORDER BY date_time DESC;

#select type, date_time from chef_view where ;


# after all the above, what you really need to know is that all the items in an order need
# to be put together in a single string 'item,item,item,item' with no spaces
# so the view can break it up into separate columns that can be used to show stuff
# this will help the GUI organise things like this:
/*
 ORDER:   ITEM:         MARK ORDER AS PREPARED:

   1      Burger           <box>
          Fanta
          Cake

   2      Cheesecake       <box>
          Bacon bun

   3      Kebab            <box>

 WHERE CLICKING THE BOX IN THE RIGHT COLUMN ON THE GUI WILL
 MARK THE ENTIRE ORDER AS PREPARED AND REMOVE IT FROM THE
 CHEF's SCREEN BY RUNNING THE QUERY AGAIN TO GET THE
 UPDATED VIEW
 */

CREATE OR REPLACE VIEW waiter_order_check AS
SELECT order_ID as `#`, type, table_number, prepared, complete,
       1st,2nd,3rd,4th,5th,6th,7th,8th,9th,10th,11th,12th,13th,
       14th,15th,16th,17th,18th,19th,20th,21st,22nd,23rd,24th,25th,
       26th,27th,28th,29th,30th
FROM items_separate_orders
WHERE prepared = 1 AND (type = 'seated' OR type = 'takeaway') AND complete = 0
ORDER BY date_time DESC;

##SELECT * FROM waiter_order_check;
/*
 SHOW ALL TAKEAWAY AND SEATED ORDERS THAT ARE PREPARED BY THE
 SHOW ALL TAKEAWAY AND SEATED ORDERS THAT ARE PREPARED BY THE CHEF
 WAITER CAN MARK AS COMPLETE TO REMOVE IT FROM THEIR VIEW
 AND UPDATE THE DB AND RUN THIS QUERY VIEW AGAIN TO REFRESH THEIR SCREEN
 */

 CREATE OR REPLACE VIEW customer_order_history AS
     SELECT date_time, prepared, complete, type, item_list FROM list_orders
     WHERE username = 'cpeng';#the customers username

SELECT * FROM customer_order_history;