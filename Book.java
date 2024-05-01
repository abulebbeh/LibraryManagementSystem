public class Book{
    private String title;
    private String author;
    private String isbn;
    private boolean isAvailable;

    public Book(String title, String author, String isbn, boolean isAvailable){
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isAvailable = isAvailable;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getAuthor(){
        return author;
    }

    public void setAuthor(String author){
        this.author = author;
    }

    public String getIsbn(){
        return isbn;
    }

    public void setIsbn(String isbn){
        if (isValidISBN(isbn)){
            this.isbn = isbn;
        }
        else {
            throw new IllegalArgumentException("Invalid ISBN. ISBN must be numeric.");
        }
    }

    public boolean isAvailable(){
        return isAvailable;
    }

    public void setAvailable(boolean available){
        isAvailable = available;
    }

    private boolean isValidISBN(String isbn){
        return isbn.matches("[0-9]+");
    }

    public void displayDetails(){
        System.out.print("Book details: Title: " + getTitle() + ", Author: " + getAuthor()
        + ", ISBN: " + getIsbn() + ", Available: " + isAvailable());
    }
}