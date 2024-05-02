public class Book{
    // Fields to store book details
    private String title;
    private String author;
    private String isbn;
    private boolean isAvailable;

    // Constructor to initialize a new Book object
    public Book(String title, String author, String isbn, boolean isAvailable){
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isAvailable = isAvailable;
    }

    // Getter method for the book's title
    public String getTitle(){
        return title;
    }

    // Setter method for the book's title
    public void setTitle(String title){
        this.title = title;
    }

    // Getter method for the book's author
    public String getAuthor(){
        return author;
    }

    // Setter method for the book's title
    public void setAuthor(String author){
        this.author = author;
    }

    // Getter method for the book's ISBN
    public String getIsbn(){
        return isbn;
    }

    // Setter method for the book's ISBN, including validation
    public void setIsbn(String isbn){
        if (isValidISBN(isbn)){
            this.isbn = isbn;
        }
        else {
            // Throw an exception if the ISBN is not numeric
            throw new IllegalArgumentException("Invalid ISBN. ISBN must be numeric.");
        }
    }

    // Method to check if the book is available
    public boolean isAvailable(){
        return isAvailable;
    }

    // Method to set the book's availability
    public void setAvailable(boolean available){
        isAvailable = available;
    }

    //Private method to check if the ISBN is numeric
    private boolean isValidISBN(String isbn){
        return isbn.matches("[0-9]+"); // Check if ISBN consists of only numbers
    }

    // Method to display details of the book
    public void displayDetails(){
        System.out.print("Book details: Title: " + getTitle() + ", Author: " + getAuthor()
        + ", ISBN: " + getIsbn() + ", Available: " + isAvailable());
    }
}