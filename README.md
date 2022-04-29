# Enviro-Bank
Banking system for a company called Enviro-Bank. Enviro-Bank runs only 2 types of accounts, namely, a savings account,  and a current account.

To run the system simply goto MainApplication.java file and run the main method. The Database which is made of a Set<> will be populated with hardcoded data.

A command menu to interact with tha system is created in order to withdraw or view all data in the database. The menu looks as follows;
    Welcome to Enviro-Bank
    Please make a choice below.
	    1. Withdraw.
	    2. View all accounts.
	    3. Exit.
   
The user is allowed to navigate in the menu using the keyboard keys.

Test cases are created and locates under the test package. NOTE all test cases are coded no framework used.
To run a test simple run the main method in each test class. There is a total of 6 test classes two in each layer.

The system is build using Domain Driven Design and Test Driven Design. All Classes and methods are tested accordingly.

The main package has the following layers:
    Domainn package - containing domain classes and database.
    Factory package - containing instantiation of each class. 
    Repository package - containing Interface of Accounts and Accounts repositories.
    Service package = containing Interface of Accounts and Accounts services exposed.
