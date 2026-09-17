# Project Overview
Library Management System is an easy-to-use desktop application created on Java Swing. This application helps you manage books within a library.
With the help of this software, one can perform operations such as adding, searching, issuing, returning, and removing books. Moreover, the system shows the total no. of books, total no. of copies, no. of available copies, and no. of issued copies.
Information about books gets saved in an automatic way into a local books.dat file.

# Features
1.	Adding new books having:
### Book ID
		Title 
	Author
		Category
		No. of copies
2.	Searching books by Book Name 
3.	Issuing books
4.	Receiving books
5.	Deleting books
6.	Checking duplicates of Book ID
7.	Avoiding issuing of books when no copies available
8.	Preventing deletion of books which are currently issued
9.	Statistics of Library:
	Total no. of Book Titles
	Total no. of Copies
	Available Copies
	Issued Copies
10.	Automatic Saving and Loading of Books Data
11.	User-Friendly Graphical User Interface (GUI)
12.	Button having rounded edges and hover effect
13.	Input validation of Book ID & No. of Copies

# Technologies and Tools Used
Programming Language
•	Java
GUI
•	Java Swing
•	Java AWT
File Handling
•	ObjectOutputStream
•	ObjectInputStream
•	Java Serialization
Data Structure
•	ArrayList
Development Tools
•	JDK (Java Development Kit)
•	 IntelliJ IDEA
•	Git and GitHub for version control and project submission

# Installation and Setup
Step 1: Installing Java
Download and install JDK on your machine.
Verify that Java is installed by opening Command Prompt/Terminal and executing:
java -version
Similarly, check Java compiler:
javac -version

Step 2: Clone/download the Project
Git clone the project:
git clone <YOUR_GITHUB_REPOSITORY_URL>
Alternatively, you may download the entire project as ZIP and unpack it.

Step 3: Opening the Project
Open the project in Java IDE like IntelliJ IDEA.
Check for the presence of following files:
Main.java
Book.java
Library.java
RoundedButton.java

Step 4: Compiling the Program
In terminal, navigate to project directory and execute:
javac *.java

Step 5: Running the Application
Run Main.java
Library Manager application window will open.


# How to Use the Application
1. Add Book
Click Add Book and enter:
•	Book ID
•	Book Title
•	Author
•	Category
•	Total Number of Copies
The book will be added to the library and its information will appear in the table.
2. Search Book
Click Search and enter the Book Name.
The application displays the books:
•	ID
•	Title
•	Author
•	Category
•	Total Copies
•	Available Copies
•	Issued Copies
3. Issue Book
Click Issue Book and enter the Book Name.
If a copy is available, the available copy count decreases and the issued copy count increases.
4. Return Book
Click Return Book and enter the Book Name.
The available copy count increases and the issued copy count decreases.
5. Remove Book
Click Remove and enter the Book Name.
A book can only be removed when none of its copies are currently issued.
6. Refresh
Click Refresh to reload the table and update the dashboard statistics.



# Testing Instructions
The following test cases can be used to verify the application.


S.No
	Action	Expected Result
1	Add a book with ID 1 and 20 copies	Book is added successfully
2	Add another book with ID 1	Duplicate ID message is displayed
3
	Search for ID 1	Book details are displayed
4
	Issue book 1	Available copies decrease by 1
5
	Return book 1	Available copies increase by 1
6
	Try to return a book with no issued copies	Error message is displayed
7
	Issue all available copies	Available copies become 0
8
	Issue the same book again when copies are 0	Application displays that no copies are available
9
	Try to remove a book with issued copies	Application prevents removal
10	Return all issued copies and remove the book	Book is removed successfully
11	Enter letters instead of a Book ID	Invalid number message is displayed
12
	Close and reopen the application	Previously saved books are loaded




