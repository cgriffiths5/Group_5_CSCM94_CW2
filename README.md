In this project we created a restuarant management system to allow for customers and staff members to interact in a virtual restaurant. Customers are able to create accounts, order food and more. Staff members are able to see orders, approve bookings, contact customers, look at reports and "deliver food". All the information and functionality is nicely displayed in a GUI using Javafx.

The steps below are how to compile the and run our program on IntelliJ:

Download all the files and open up the "Group5-A2" folder in your chosen IDE.

A desktop app "XAMPP" needs to be installed to open the database on the program so follow the steps to do that. When thats downloaded, open it and and in the "Actions" column press the "Start" button that is on the "MySQL" row. 

In IntelliJ open the path to the "SQL" folder ("Group5-A2" -> ".idea" -> "src" -> "main" -> "SQL") and open "structure.sql", "data.sql" and "views.sql" inside the folder. In the serach bar in  the top right hand corner write "Data source properties" and click on the top choice. A new window will appear and you need to click the "+" sysmbol in the top left corner. Scroll down and click "MariaDB". In the "User:" box wrtie in "root" and in the "Database:" box write in "cafedb". Now click "Test Connection" in the bottome left corner, then click "Apply" and then "OK". Run the "structure.sql", "data.sql" and "views.sql" in this order so everything is setup.

Now click "File" button in the IntelliJ window tool bar in the top left corner and then click "Project Structure". On the left hand side click on "Libraries" and then click on the "+" symbol, then click "From Maven" in the search bar enter "org.mariadb.jdbc:mariadb-java-client:2.6." and click on the option that ends in ":2.6.1". Then click "OK".

Go back to the "File" menu and click on "Settings" and click on the "Plugins" option down the left hand side. In the search bar write "JavaFX Runtime for Plugins" and install the top option. Click "Apply" and then "OK".

Right click the folder "Group5-A2" and go down to the "Maven" option and click on "Generate Sources and Update Folders". Then right click the folder "Group5-A2" and go down to the "Maven" option and click on "Reload project".

Now the database, JavaFX plugins and the external libraries have been installed.

In the "java" folder ("Group5-A2" -> ".idea" -> "src" -> "main" -> "java") open the "com.cafe.group5a2" folder then open the "Cafe94" java class. Run this class and the program should start. Below are the username and password combinations to logon as a staff member or as a customer. You can also register as a new customer as well.

Logon as Manager: 
	Username = atucker
	Password = atucker1
 
Logon as Waiter:
	Username = cturner
	Password = cturner1

Logon as Chef: 
	Username = cgriffiths
	Password = cgriffiths1

Logon as Driver: 
	Username = jyong 
	Password = jyong1

Logon as Customer: 
	Username = cpeng
	Password = cpeng1

