import java.util.Scanner;

/*1. Book Class
 * Fields:
 *  -private String title, author, ISBN;
 *  -private boolean isAvailable
 * Constructor:
 *  Book(title, author, ISBN, isAvailable)
 * Methods:   
 *  getTitle()
 *  setTitle(newTitle) 
 *  getAuthor()
 *  setAuthor(newAuthor)
 *  getISBN()
 *  setISBN(newISBN)
 *  isAvailable()
 *  setAvailable(availability)
 * 
 * 2. LibraryItem Interface 
 * Methods:
 *  checkout()
 *  returnItem()
 *  getStatus()
 * 
 * 3. Inheritable Classes
 * FictionBook extends Book
 *  Extra Field: private String genre;
 *  Methods:
 *  displayDetails() //Override to include subject
 * 
 * 4. LibraryCatalog Class
 * Fields:
 *  private ArrayList books;
 * Constructor: LibraryCatalog()
 * Methods:
 *  addBook(Book book)
 *  removeBookByISBN(String ISBN)
 *  searchBookByTitle(String title)
 *  checkout(String ISBN) //Implements LibraryItem
 *  returnItem(String ISBN) //Implements LibraryItem
 *  getStatus(String ISBN) //Implements LibraryItem
 * 
 * ***Enhanced LibraryCatalog Class with User Input Method
 * 1. AddBookViaUserInput() Method:
 *  Prompt the user for book details (title, author, ISBN, availability, and if applicable, genre or subject based on the book type)
 *  Create a Book, FictionBook, or NonFictionBook object based on the input
 *  Add the created book object to the ArrayList<Book>
 * 2. Integration in the Main Application
 *  Provide a menu option for the user to select if they want to add a book
 *  Based on the user's choice, invoke addBookViaUserInput()
 * 
 * 
 * 5. Main Application
 * Flow: 
 *  Create Book, FictionBook, and NonFictionBook objects
 *  Add to LibraryCatalog
 *  Perform a checkout and return operation
 *  Display status after operations
 */

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        LibraryCatalog catalog = new LibraryCatalog();

        boolean running = true;
        while (running){
            System.out.println("Choose an option:");
            System.out.println("1. Add Book");
            System.out.println("2. Checkout Book");
            System.out.println("3. Return Book");
            System.out.println("4. Search Book");
            System.out.println("5. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice){
                case 1:
                    addBookViaUserInput(scanner, catalog);
                    break;
                case 2:
                    checkoutBook(scanner, catalog);
                    break;
                case 3:
                    returnBook(scanner, catalog);
                    break;
                case 4:
                    searchBook(scanner, catalog);
                    break;
                case 5:
                    running = false;
                    System.out.println("Exiting program.");
                    break;
                default:
                System.out.println("Invalid option. Please choose again.");
            }
        }
        scanner.close();
    }

private static void addBookViaUserInput(Scanner scanner, LibraryCatalog catalog){
    System.out.println("Enter book type (Fiction/NonFiction): ");
    String type = scanner.nextLine();
    System.out.println("Enter title: ");
    String title = scanner.nextLine();
    System.out.println("Enter author: ");
    String author = scanner.nextLine();
    System.out.println("Enter ISBN (numeric only): ");
    String isbn = scanner.nextLine();

    while(!isbn.matches("[0-9]+")){
        System.out.println("Invalid ISBN. Please enter a numeric value only.");
        isbn = scanner.nextLine();
    }
    System.out.println("Is this book available? (true/false): ");
    boolean isAvailable = scanner.nextBoolean();
    scanner.nextLine();

    if (type.equalsIgnoreCase("Fiction")){
        System.out.println("Enter genre: ");
        String genre = scanner.nextLine();
        FictionBook book = new FictionBook(title, author, isbn, isAvailable, genre);
        catalog.addBook(book);
        System.out.println("Fiction book added: " + book.getTitle());
    }
    else if (type.equalsIgnoreCase("NonFiction")){
        System.out.println("Enter subject: ");
        String subject = scanner.nextLine();
        NonFictionBook book = new NonFictionBook(title, author, isbn, isAvailable, subject);
        catalog.addBook(book);
        System.out.println("NonFiction book added: "+ book.getTitle());
    }
    else{
        System.out.println("Invalid book type. Book not added.");
    }
}

private static void checkoutBook(Scanner scanner, LibraryCatalog catalog){
    System.out.println("Enter ISBN of the book to checkout:");
    String isbn = scanner.nextLine();
    if(catalog.checkout(isbn)){
        System.out.println("Successfully checked out book!");
    }
    else{
        System.out.println("Failed to check out the book. It may not exist or is already checked out.");
    }
}

private static void returnBook(Scanner scanner, LibraryCatalog catalog){
    System.out.println("Enter ISBN of the book to return:");
    String isbn = scanner.nextLine();
    if(catalog.returnItem(isbn)){
        System.out.println("Book returned successfully.");
    }
    else{
        System.out.println("Failed to return the book. It may not exist or is not checked out.");
    }
}

private static void searchBook(Scanner scanner, LibraryCatalog catalog){
    System.out.println("Enter the title of the book to search:");
    String title = scanner.nextLine();
    Book book = catalog.searchBookByTitle(title);
    if (book != null){
        book.displayDetails();
    }
    else{
        System.out.println("Book not found:");
    }
    }
}