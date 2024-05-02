# LibraryManagementSystem
A simple Library Management System (LMS) using Java. This system will manage a collection of books and allow for adding, removing, and searching for books in the collection.

**Book Class Fields:**
- private String title, author, isbn;
- private boolean isAvailable;

Constructor:
- Book(title, author, isbn, isAvailable)

Methods:
- getTitle()
- setTitle(newTitle)
- getAuthor()
- setAuthor(newAuthor)
- getISBN()
- setISBN(newISBN)
- isAvailable()
- setAvailable(availability)
- displayDetails()
- isValidISBN(isbn)

**LibraryItem Interface Methods:**
- checkout(isbn)
- returnItem(isbn)
- getStatus(isbn)

**Inheritable Classes:**
- FictionBook extends Book

Extra Field for FictionBook:
- private String genre;
  
**Methods for FictionBook:**
- displayDetails() // Includes genre
- NonFictionBook extends Book
  
Extra Field for NonFictionBook:
- private String subject;
  
**Methods for NonFictionBook:**
- displayDetails() // Includes subject
- LibraryCatalog Class Fields:
- private ArrayList<Book> books;

Constructor:
- LibraryCatalog()

Methods:
- addBook(Book book)
- removeBookByISBN(String ISBN)
- searchBookByTitle(String title)
- checkout(String ISBN) // Implements LibraryItem
- returnItem(String ISBN) // Implements LibraryItem
- getStatus(String ISBN) // Implements LibraryItem
- findBookByISBN(String ISBN) // Private helper method to find a book

**Main Application Flow:**
- Create instances of Book, FictionBook, and NonFictionBook
- Add instances to LibraryCatalog
- Perform checkout and return operations
- Display the status of books after operations
- Interface with users to perform operations like adding, searching, checking out, and returning books
- Run a loop to keep the application running until the user decides to exit

**AddBookViaUserInput() Method:**
- Prompt the user for book details (title, author, ISBN, availability, and if applicable, genre or subject based on the book type)
- Create a Book, FictionBook, or NonFictionBook object based on the input
- Add the created book object to the ArrayList in LibraryCatalog
- Integration in the Main Application for dynamic user interaction
- Provide a menu option for the user to select if they want to add a book
- Based on the user's choice, invoke addBookViaUserInput()
