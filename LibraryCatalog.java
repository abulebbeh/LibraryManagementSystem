import java.util.ArrayList;

// This class represents the catalog of books in the library
public class LibraryCatalog implements LibraryItem{
    // List to store books in the catalog
    private ArrayList<Book> books = new ArrayList<>();

    // Method to add a book to the catalog
    public void addBook(Book book){
        books.add(book);
        System.out.println("Added book.");
    }

    // Method to remove a book from the catalog by its ISBN
    public boolean removeBookByISBN(String isbn){
        return books.removeIf(book -> book.getIsbn().equals(isbn));
    }

    // Method to search for a book by its title 
    public Book searchBookByTitle(String title){
        for (Book book : books){
            if (book.getTitle().equalsIgnoreCase(title)){
                return book; // Returns book if found
            }
        }
        return null; // Returns null if no matching book is found
    }

    // Method to checkout a book using its ISBN, marking it as unavailable (if found and available)
    @Override
    public boolean checkout(String isbn){
        Book book = findBookByISBN(isbn);
        if (book != null && book.isAvailable()){
            book.setAvailable(false); // Mark the book as unavailable
            return true;
        }
        return false; // Return false if the book is not available or not found
    }

    // Method to return a book to the library, marking it as available
    @Override
    public boolean returnItem(String isbn){
        Book book = findBookByISBN(isbn);
        if (book != null && !book.isAvailable()){
            book.setAvailable(true); // Mark the book as available
            return true;
        }
        return false; // Return false if the book is not found or already available
        
    }

    // Method to check the availability status of a book by its ISBN
    @Override
    public boolean getStatus(String isbn){
        Book book = findBookByISBN(isbn);
        return book != null && book.isAvailable(); // Return true if the book is available
    }

    // Helper method to find book by its ISBN
    private Book findBookByISBN(String isbn){
        for (Book book : books){
            if (book.getIsbn().equals(isbn)){
                return book; // Return the book if found
            }
        }
        return null; // Return null if no matching book is found
    }
}