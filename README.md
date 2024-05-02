# LibrarryManagementSystemSpringBoot
Project Overview:
  The Library Management System is a Java-based application designed to streamline the management of a library's operations. It allows librarians to efficiently manage the library's resources, such as books, and enables users to perform various tasks, including browsing available books, borrowing, returning, and updating book information.

In Scope:
1. Show Available Books
2. Add a Book
3. Issue Book
4. Return Book
5. Update Existing Book
6. Delete Existing Book

Database Design:
To facilitate the functionalities of the library management system, we propose the following database schema:

Books Table:
Book_id (Primary Key): Unique identifier for each book.
Book_name: Name of the book.
Authors_name: Name of the author(s).
Price: Price of the book.
Available: Indicator of whether the book is available for borrowing (1 for available, 0 for unavailable).

Student Table:
 St_id: Student ID.
St_name: Name of the student.
Book_id (Foreign Key): ID of the book borrowed by the student.
Issue_date: Date when the book was issued to the student.
Return_date: Date when the book is expected to be returned by the student.
Borrow: Indicator of the borrow status (e.g., "Borrowed", "Returned").

Fine Table:
St_id: Student ID.
St_name: Name of the student.
Book_id: ID of the book for which fine is applicable.
Returned_date: Date when the book was returned by the student.
Days_delayed: Number of days the book was delayed in return.
Fine_fees: Fine amount charged for the delayed return of the book.

Conclusion:
The Library Management System provides an efficient and user-friendly platform for managing library operations. By enabling librarians to perform tasks such as adding, updating, and deleting books, as well as issuing and returning books, it enhances the overall efficiency and organization of the library.
This document outlines the main functionalities of the Library Management System, detailing the various actions that users and librarians can perform within the system. It provides a clear overview of the system's features and interactions, facilitating effective communication and understanding of its functionality.

