# Library Management System

## Problem Statement

Managing books manually in a library can be time-consuming and may lead to errors in tracking book availability, issued books, and returned books. There is a need for a simple computerized system that can store book information and perform basic library operations efficiently.

The Library Management System is a Java-based desktop application developed to manage book records and simplify common library operations such as adding, searching, issuing, returning, and removing books.

## Scope of the Project

The scope of this project includes managing book records in a small or medium-sized library. The system allows users to:

- Add new books with their ID, title, author, category, and number of copies.
- Search for books using their name/title.
- Issue available copies of a book.
- Return issued copies.
- Remove books that are no longer required.
- View total, available, and issued copies through the dashboard.
- Store book data using file serialization so that records remain available after closing the application.

The project focuses on basic library operations and does not include advanced features such as online reservations, user accounts, fine calculation, or database connectivity.

## Target Users

The system is mainly designed for:

- Small and medium-sized libraries.
- Librarians for managing book records.
- Library staff for issuing and returning books.
- Students or users who need to search for available books.

## High-Level Features

1. **Add Book**  
   Allows users to add a new book with its ID, title, author, category, and total copies.

2. **Search Book by Name**  
   Allows users to search for a book using its title instead of the Book ID.

3. **Issue Book by Name**  
   Allows an available copy of a book to be issued using the book title.

4. **Return Book by Name**  
   Allows an issued book copy to be returned using the book title.

5. **Remove Book by Name**  
   Allows a book to be removed using its title if no copies are currently issued.

6. **Dashboard**  
   Displays the total number of book titles, total copies, available copies, and issued copies.

7. **Book Table**  
   Displays complete information about all books in an organized table.

8. **Data Persistence**  
   Book records are stored in a `books.dat` file using Java serialization, allowing data to be retained between program runs.

9. **User-Friendly GUI**  
   Provides a simple Java Swing interface with buttons, dashboard cards, and a book table for easy interaction.
