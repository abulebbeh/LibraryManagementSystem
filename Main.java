/*
 * Doaa Abulebbeh
 * Professor Allos
 * CSIS 294 – INTERM JAVA PROG/DATA STRUCT
 * Lab Exercise: Implementing a Simple Library Management System in Java
 */

import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        // Setup for receiving user input
        Scanner scanner = new Scanner(System.in);
        // Initialize the library catalog
        LibraryCatalog catalog = new LibraryCatalog();

        // Flag to control the main program loop
        boolean running = true;
        while (running){
            // DDisplay options for the user
            System.out.println("Choose an option:");
            System.out.println("1. Add Book");
            System.out.println("2. Checkout Book");
            System.out.println("3. Return Book");
            System.out.println("4. Search Book");
            System.out.println("5. Exit");
            int choice = scanner.nextInt(); // Get user choise
            scanner.nextLine();

            // Switch to process the user's choice
            switch (choice){
                case 1: // Add a book to the catalog
                    addBookViaUserInput(scanner, catalog);
                    break;
                case 2: // Checkout a book from the catalog
                    checkoutBook(scanner, catalog);
                    break;
                case 3: // Return a book from the catalog
                    returnBook(scanner, catalog);
                    break;
                case 4: // Search for a book in the catalog
                    searchBook(scanner, catalog);
                    break;
                case 5: // Exit the program
                    running = false;
                    System.out.println("Exiting program.");
                    break;
                default: // Handle invalid options
                System.out.println("Invalid option. Please choose again.");
            }
        }
        scanner.close();
    }

// Method to add a book via user input
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
        // Create a fiction book and add to catalog
        FictionBook book = new FictionBook(title, author, isbn, isAvailable, genre);
        catalog.addBook(book);
        System.out.println("Fiction book added: " + book.getTitle());
    }
    else if (type.equalsIgnoreCase("NonFiction")){
        System.out.println("Enter subject: ");
        String subject = scanner.nextLine();
        // Create a non-fiction book and add to catalog
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