public class NonFictionBook extends Book{
    // Field to store the genre of the non-fiction book
    private String subject;

    // Constructor to initialize a new NonFictionBook object
    public NonFictionBook(String title, String author, String isbn, boolean isAvailable, String subject){
        super(title, author, isbn, isAvailable);
        this.subject = subject;
    }

    // Override the displayDetails method to include the subject of the book 
    public void displayDetails(){
        System.out.println("Title: " + getTitle() + ", Author: " + getAuthor() + ", ISBN: " + getIsbn() 
        + ", subject: " + subject + ", Available: " + isAvailable());
    }
}