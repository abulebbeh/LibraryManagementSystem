// Interface for library items
public interface LibraryItem{
    boolean checkout(String isbn); // Method to checkout book using its ISBN
    boolean returnItem(String isbn); // Method to return a book using its ISBN
    boolean getStatus(String isbn); // Method to check availabilit of book using its ISBN
}