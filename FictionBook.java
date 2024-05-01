public class FictionBook extends Book{
    private String genre;

    public FictionBook(String title, String author, String isbn, boolean isAvailable, String genre){
        super(title, author, isbn, isAvailable);
        this.genre = genre;
    }

    public void displayDetails(){
        System.out.println("Title: " + getTitle() + ", Author: " + getAuthor() + ", ISBN: " + getIsbn() 
        + ", Genre: " + genre + ", Available: " + isAvailable());
    }
}