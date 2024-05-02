# LibraryManagementSystem
A simple Library Management System (LMS) using Java. This system will manage a collection of books and allow for adding, removing, and searching for books in the collection.

The Workflow:

Book Class Fields: 
- private String title, author, ISBN; 
- private boolean isAvailable

Constructor:
- Book(title, author, ISBN, isAvailable)

Methods:
- getTitle()
- setTitle(newTitle)
- getAuthor()
- setAuthor(newAuthor)
- getISBN()
- setISBN(newISBN)
- isAvailable()
- setAvailable(availability)

LibraryItem Interface Methods: 
- checkout()
- returnItem()
- getStatus()

Inheritable Classes 
- FictionBook extends Book

Extra Field:
- private String genre;

Methods:
- displayDetails() //Override to include subject

LibraryCatalog Class Fields: 
- private ArrayList books; 

Constructor: 
- LibraryCatalog() 

Methods: 
- addBook(Book book)
- removeBookByISBN(String ISBN)
- searchBookByTitle(String title)
- checkout(String ISBN) //Implements LibraryItem
- returnItem(String ISBN) //Implements
- LibraryItem getStatus(String ISBN) //Implements LibraryItem

Main Application Flow: 
- Create Book, FictionBook, and NonFictionBook objects 
- Add to LibraryCatalog
- Perform a checkout and return operation
- Display status after operation
- Enhanced LibraryCatalog Class with User Input Method

AddBookViaUserInput() Method: 
- Prompt the user for book details (title, author, ISBN, availability, and if applicable, genre or subject based on the book type)
- Create a Book, FictionBook, or NonFictionBook object based on the input
- Add the created book object to the ArrayList
- Integration in the Main Application
- Provide a menu option for the user to select if they want to add a book
- Based on the user's choice, invoke addBookViaUserInput()
