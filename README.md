# Software development - Continuous Assessment 2 - Library management system

## Authors

- Dimie E
- Eman A
- Vince K

## Requirements

### To do

1. Use inheritance and interfaces to design an efficient class hierarchy. Also include some lambdas.
2. Use stacks, queues and/or linked lists to store and manipulate the created objects
3. File handling
    1. Implement operations to read and write data to these files, enabling the system to load and save catalogue data
4. Sorting & Searching
    1. Implement a sort and search facility for books, authors and users
    2. Consider the various sorting and searching algorithms available and justify the appropriateness of your selected algorithms and data structures in terms of complexity and performance profile when compared to others
5. Implement methods to perform the following library operations:
   1. Return a book (update book availability and library user's borrowed books)
   2. List available books
6. Include a report that explains the design decisions, classes, interfaces, source code, external files and Maven dependencies used in the project

### Done

1. Define the following classes:
   1. Book/Audio Book: Represent with attributes like title, author, ISBN, availability status
   2. Theses/Dissertation: Represent with attributes like title, author, topic, abstract, date published, availability status
   3. CD/DVD: Represent with attributes like title, producer, director, playtime, availability status
   4. Author: Represent attributes like name, list of authored books
   5. Library User: Represent with attributes like name, ID, list of borrowed assets
2. Implement appropriate constructors and getters/setters
3. File Handling
   1. Create external CSV files, eg, books.csv, authors.csv, users.csv, etc, to store information about books, authors and users, respectively (Apache Commons CSV)
4. Error Handling: implement error handling for file operations, user input validation and any other potential exceptions
5. Implement methods to perform the following library operations:
   1. Add a book to the library
   2. Add an author to the library
   3. Add a library user to the system
   4. Borrow a book (update book availability and library user's borrowed books)
   5. List books borrowed by a user
   6. List books authored by an author
6. Implement the following Maven Dependencies:
   1. External library for reading and writing to external files
   2. JUnit to thoroughly test the program
7. User Interface
   1. Create a simple command-line user interface to interact with the library system
   2. Allow users to execute library operations through text-based menus
