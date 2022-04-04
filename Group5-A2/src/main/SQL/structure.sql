/**
 * @author Adam Tucker
 */

DROP DATABASE IF EXISTS cafeDB;
CREATE DATABASE cafeDB;

USE cafeDB;

DROP TABLE IF EXISTS menu;

CREATE TABLE menu
(
    menu_ID     SERIAL,                      ## primary key
    item        VARCHAR(50) UNIQUE,          ## could use this as the primary key but then it's slow
    ## because of string comparisons rather than int comparisons
    description LONGTEXT    NOT NULL UNIQUE, ##longtext for wordy descriptions above 255 char
    category    varchar(20) NOT NULL,
    ## the current specials and quickly delete old ones or new ones
    ## in java we could do something where the price is set to null,
    ## and as a result, we do a delete query to delete all specials with null price
    ## easy way to update specials to only keep current ones on the menu
    price       DECIMAL(4, 2) DEFAULT NULL,  ## if null then the item is not available to order
    CONSTRAINT pk_menu PRIMARY KEY (menu_ID)
    ## XOR because it must be either food or drink, not both
);

DROP TABLE IF EXISTS users;

CREATE TABLE users
(
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

DROP TABLE IF EXISTS capacity;

CREATE TABLE capacity
(
    cap_ID       BIGINT AUTO_INCREMENT,
    table_number INT                  NOT NULL,
    seats        INT                  NOT NULL,
    is_available BOOLEAN DEFAULT TRUE NOT NULL,
    CONSTRAINT pk_cap PRIMARY KEY (cap_ID, table_number),
    CONSTRAINT table_range CHECK (table_number > 0 AND table_number < 12),
    CONSTRAINT seats_range CHECK (seats = 2 OR seats = 4 OR seats = 8 OR seats = 10),
    date         DATE                 NOT NULL,
    hour         INT                  NOT NULL
);

DROP TABLE IF EXISTS bookings;

CREATE TABLE bookings
(
    booking_ID BIGINT AUTO_INCREMENT,
    b_user_ID  BIGINT,
    b_cap_ID   BIGINT UNIQUE,
    guests     INT NOT NULL,
    approved   BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (b_user_ID) REFERENCES users (user_ID),
    FOREIGN KEY (b_cap_ID) REFERENCES capacity (cap_ID),
    CONSTRAINT pk_bookings PRIMARY KEY (booking_ID, b_user_ID, b_cap_ID),
    CONSTRAINT max_guests CHECK (guests < 77)
);


DROP TABLE IF EXISTS orders;

CREATE TABLE orders
(
    order_ID     BIGINT AUTO_INCREMENT,
    FK_user_ID   BIGINT,
    CONSTRAINT pk_orders PRIMARY KEY (order_ID, FK_user_ID),
    type         ENUM ('takeaway', 'delivery', 'seated'),
    table_number INT               DEFAULT NULL,
    item_list    LONGTEXT NOT NULL,
    date_time    DATETIME NOT NULL DEFAULT NOW(),
    prepared     BOOLEAN           DEFAULT FALSE,
    complete     BOOLEAN           DEFAULT FALSE
);