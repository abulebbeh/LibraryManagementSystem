public class NonFictionBook extends Book{
    private String subject;

    public NonFictionBook(String title, String author, String isbn, boolean isAvailable, String subject){
        super(title, author, isbn, isAvailable);
        this.subject = subject;
    }

    public void displayDetails(){
        System.out.println("Title: " + getTitle() + ", Author: " + getAuthor() + ", ISBN: " + getIsbn() 
        + ", subject: " + subject + ", Available: " + isAvailable());
    }
}