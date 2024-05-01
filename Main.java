/*
 * Doaa Abulebbeh
 * Professor Allos
 * CSIS 294 – INTERM JAVA PROG/DATA STRUCT
 * Lab Exercise: Implementing a Simple Library Management System in Java
 */

import java.util.Scanner;

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
