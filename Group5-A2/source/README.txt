HOW TO INSTALL AND RUN:

This guide assumes the use of the intelliJ IDE and was developed using jdk-17.0.2 and mySQL with JDBC

Unzip the folder, inside 'Group5-A2' open source in intelliJ as a project

Install XAMPP and start mySQL, (username should be the default 'root' and password should be empty)

In IntelliJ open the "SQL" folder "source/src/main/SQL"
Open the structure.sql file, at which point you will be prompted by intelliJ to set your SQL dialect
set it to 'MariaDB'.
You will also be prompted to make a connection.
If not:
In the search bar in the top right-hand corner write "Data source properties"
and click on the top choice. 
A new window will appear, click the "+" symbol in the top left corner.
Scroll down and click "MariaDB". Install the missing drivers if prompted at the bottom.
Name = @localhost, host = localhost, user = root, port = 3306.
the URL should be 'jdbc:mariadb://localhost:3306/cafedb' and the password and database empty
Now click "Test Connection" in the bottom left corner, then click "Apply" and then "OK".
open "structure.sql" execute the line "CREATE DATABASE cafedb" ONLY.
Now go to the right of IntelliJ to open the database connection settings,
set Name = cafedb@localhost (at the top), and database = cafedb (near the bottom)
open "data.sql" and "views.sql" and execute both files using your database connection
In the IntelliJ database explorer you should now have 5 tables, 13 views, 2 routines in the cafedb database.

In the IntelliJ toolbar:
File -> project structure
In the window:
+ in the top left, 'from maven', search for 'mariadb-java-client:2.6.'
click the version 2.6.0 and then 'OK'
In the IntelliJ toolbar:
File -> settings,
In the window go to 'plugins', search for 'JavaFX Runtime for Plugins' and install it. Click Apply, OK.

In the project explorer on the left, right-click 'source' (the top folder), and go to the bottom and click 'Maven',
click "Generate Sources and Update Folders", do this again but instead click "Reload Project"

At this point in the external libraries you should see your JDK version, the JDBC connection mariadb.jdbc.java.client,
and the following number of each of these libraries:
13 openjfx, 3 kordamp, 4 junit, 1 controlsfx, 1 apiguardian, 1 synedra, 5 hansolo, and 1 disc library

Navigate to source/src/main/java/com.cafe.group5a2/Main.java and right-click to run the file
The program should open a login/registration window.

Below are the username and password combinations to login as a staff member or as a customer.
You can register as a customer and only a customer here.
(to register a new staff you must first log on as the manager below and add a new staff member)

Logon as Manager: Username = atucker Password = atucker1

Logon as Waiter: Username = cturner Password = cturner1

Logon as Chef: Username = cgriffiths Password = cgriffiths1

Logon as Driver: Username = jyong Password = jyong1

Logon as Customer: Username = cpeng Password = cpeng1   OR   Username = ctao Password = ctao1

--------------------------------------------------------------------------------------------------

This is a restaurant management system using a database built using the 3 files in the SQL folder.

Unregistered customers are able to:

register with the system creating a new profile with their address, name, username and password

Customers are able to:

order takeaways or deliveries,
see their order history including viewing each item in an order, when it was placed etc.,
check availability,
book enough table for any number of guests up to the total seats in the restaurant.

Waiters are able to:

take a customer's table-side order,
approve or decline a customer's booking,
see what takeaway and in house orders have been prepared by the chefs,
report a problem with an order so the chef can remake it.

Chefs are able to:

see all new unprepared orders and mark them as prepared so the waiter can see them,
manage the menu including adding specials and adding or removing menu items.

Drivers are able to:

see all prepared and uncompleted delivery orders and the associated customer address,
mark orders as complete when they are delivered or report a problem, so it can be remade by the chefs.

Managers are able to:

View detailed reports about the restaurant and customers (activity, not private data),
View all the staff including the ability to remove staff or add new ones.