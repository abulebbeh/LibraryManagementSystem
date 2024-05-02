public class FictionBook extends Book{
    // Field to store the genre of the fiction book
    private String genre;

    // Constructor to initialize a new FictionBook object
    public FictionBook(String title, String author, String isbn, boolean isAvailable, String genre){
        super(title, author, isbn, isAvailable); // Call to superclass Book constructior
        this.genre = genre;
    }

    // Override the displayDetails method to include the genre of the book 
    public void displayDetails(){
        System.out.println("Title: " + getTitle() + ", Author: " + getAuthor() + ", ISBN: " + getIsbn() 
        + ", Genre: " + genre + ", Available: " + isAvailable());
    }
}