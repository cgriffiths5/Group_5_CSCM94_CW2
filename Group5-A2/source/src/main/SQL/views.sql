/**
 * @author Adam Tucker
 */
USE cafeDB;

CREATE OR REPLACE VIEW customers as
SELECT *
FROM users
WHERE role = 'customer';

CREATE OR REPLACE VIEW staff as
SELECT *
FROM users
WHERE role != 'customer';


SELECT *
from (
         SELECT *
         from bookings
                  INNER JOIN capacity
                             on bookings.b_cap_ID = capacity.cap_ID) as sel1
         INNER JOIN users
                    ON users.user_ID = sel1.b_user_ID;

CREATE OR REPLACE VIEW list_orders as
SELECT *
FROM orders
         INNER JOIN users ON (orders.order_ID, orders.FK_user_ID) =
                             (orders.order_ID, users.user_ID);


CREATE OR REPLACE VIEW items_separate_orders as
SELECT order_ID,
       user_ID,
       FK_user_ID,
       username,
       password,
       table_number,
       prepared,
       complete,
       (SUBSTRING_INDEX(item_list, ',', 1))                            AS 1st,
       (SUBSTRING_INDEX(SUBSTRING_INDEX(item_list, ',', 2), ',', -1))  AS 2nd,
       (SUBSTRING_INDEX(SUBSTRING_INDEX(item_list, ',', 3), ',', -1))  AS 3rd,
       (SUBSTRING_INDEX(SUBSTRING_INDEX(item_list, ',', 4), ',', -1))  AS 4th,
       (SUBSTRING_INDEX(SUBSTRING_INDEX(item_list, ',', 5), ',', -1))  AS 5th,
       (SUBSTRING_INDEX(SUBSTRING_INDEX(item_list, ',', 6), ',', -1))  AS 6th,
       (SUBSTRING_INDEX(SUBSTRING_INDEX(item_list, ',', 7), ',', -1))  AS 7th,
       (SUBSTRING_INDEX(SUBSTRING_INDEX(item_list, ',', 8), ',', -1))  AS 8th,
       (SUBSTRING_INDEX(SUBSTRING_INDEX(item_list, ',', 9), ',', -1))  AS 9th,
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
       type,
       date_time,
       f_name,
       l_name,
       role,
       house_number,
       postcode
FROM orders
         INNER JOIN users ON (orders.order_ID, orders.FK_user_ID) =
                             (orders.order_ID, users.user_ID);


CREATE OR REPLACE VIEW chef_view AS
SELECT order_ID as `#`,
       type,
       prepared,
       date_time,
       1st,
       2nd,
       3rd,
       4th,
       5th,
       6th,
       7th,
       8th,
       9th,
       10th,
       11th,
       12th,
       13th,
       14th,
       15th,
       16th,
       17th,
       18th,
       19th,
       20th,
       21st,
       22nd,
       23rd,
       24th,
       25th,
       26th,
       27th,
       28th,
       29th,
       30th
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
SELECT order_ID as `#`,
       type,
       table_number,
       prepared,
       complete,
       1st,
       2nd,
       3rd,
       4th,
       5th,
       6th,
       7th,
       8th,
       9th,
       10th,
       11th,
       12th,
       13th,
       14th,
       15th,
       16th,
       17th,
       18th,
       19th,
       20th,
       21st,
       22nd,
       23rd,
       24th,
       25th,
       26th,
       27th,
       28th,
       29th,
       30th
FROM items_separate_orders
WHERE prepared = 1
  AND (type = 'seated' OR type = 'takeaway')
  AND complete = 0
ORDER BY date_time DESC;

##SELECT * FROM waiter_order_check;
/*
 SHOW ALL TAKEAWAY AND SEATED ORDERS THAT ARE PREPARED BY THE
 SHOW ALL TAKEAWAY AND SEATED ORDERS THAT ARE PREPARED BY THE CHEF
 WAITER CAN MARK AS COMPLETE TO REMOVE IT FROM THEIR VIEW
 AND UPDATE THE DB AND RUN THIS QUERY VIEW AGAIN TO REFRESH THEIR SCREEN
 */

CREATE OR REPLACE VIEW customer_order_history AS
SELECT date_time, prepared, complete, type, item_list
FROM list_orders
WHERE username = 'cpeng';
#the customers username

#SELECT *
#FROM customer_order_history;


#SELECT password FROM users
#WHERE username = 'cpeng';

#SELECT price FROM menu ORDER BY category DESC;


#UPDATE orders
#SET complete = 1
#WHERE order_ID = orderIDLabel1

#UPDATE orders
#SET complete = 1
#WHERE order_ID = orderIDLabel2

#SELECT order_ID, table_number, complete FROM orders
#WHERE type='seated' AND prepared=1 AND complete=0
#ORDER BY date_time
#LIMIT 4;

#DELETE FROM orders WHERE order_ID > 18;
#DELETE FROM orders WHERE order_ID > 0;
#SELECT * FROM capacity WHERE hour = 2200 AND date = 20220404 ORDER BY table_number;


CREATE OR REPLACE VIEW waiter_booking_view AS
SELECT booking_ID as b_ID,
       user_ID,
       cap_ID,
       l_name,
       date,
       hour,
       guests,
       table_number
FROM bookings
         INNER JOIN capacity
                    ON bookings.b_cap_ID = capacity.cap_ID
         INNER JOIN users u on bookings.b_user_ID = u.user_ID
WHERE ((date > CURRENT_DATE || (date = CURRENT_DATE && hour > (2000 + HOUR(CURRENT_TIMESTAMP) * 100))) && approved = 0)
ORDER BY date, hour;

CREATE OR REPLACE VIEW today_bookings AS
SELECT booking_ID as b_ID,
       user_ID,
       cap_ID,
       l_name,
       date,
       hour,
       guests,
       table_number
FROM bookings
         INNER JOIN capacity
                    ON bookings.b_cap_ID = capacity.cap_ID
         INNER JOIN users u on bookings.b_user_ID = u.user_ID
WHERE date = CURRENT_DATE && ((hour >= (HOUR(CURRENT_TIME) * 100)) - 1000) && approved = 1
ORDER BY hour;

#SELECT * FROM today_bookings;

SELECT *
FROM waiter_booking_view;
#for customer
#SELECT * from waiter_booking_view
#WHERE user_ID = 'username';

#SELECT order_ID, table_number, date_time, type FROM orders
# WHERE complete = 1 AND FK_user_ID = 6 ORDER BY date_time LIMIT 21;

CREATE OR REPLACE VIEW active_customer AS
(
SELECT username, f_name, l_name, COUNT(user_ID) AS customerMostOrders
FROM orders
         INNER JOIN users
                    ON orders.FK_user_ID = users.user_ID
WHERE role = 'customer');

#SELECT * FROM active_customer;

CREATE OR REPLACE VIEW most_booked_hour AS
(
SELECT *
FROM (SELECT hour, count(*) as count
      FROM capacity
      WHERE is_available = 0
      GROUP BY hour
      ORDER BY hour DESC) as s);

CREATE OR REPLACE VIEW most_booked_day AS
(
SELECT *
FROM (SELECT date, count(*) as count
      FROM capacity
      WHERE is_available = 0
      GROUP BY date
      ORDER BY date DESC) as s);

CREATE OR REPLACE VIEW most_orders_hour AS
(
SELECT *
FROM (SELECT HOUR(date_time) as hour, count(*) as count
      FROM orders
      GROUP BY hour
      ORDER BY hour DESC) as s);

SELECT *
FROM most_orders_hour;

SELECT *
FROM items_separate_orders
WHERE 1st = 'Margherita pizza';


#SELECT * FROM most_booked_hour;

#SELECT * FROM capacity WHERE is_available = 0 ORDER BY hour;


