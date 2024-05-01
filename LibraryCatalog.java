import java.util.ArrayList;

public class LibraryCatalog implements LibraryItem{
    private ArrayList<Book> books = new ArrayList<>();

    public void addBook(Book book){
        books.add(book);
        System.out.println("Added book.");
    }

    public boolean removeBookByISBN(String isbn){
        return books.removeIf(book -> book.getIsbn().equals(isbn));
    }

    public Book searchBookByTitle(String title){
        for (Book book : books){
            if (book.getTitle().equalsIgnoreCase(title)){
                return book;
            }
        }
        return null;
    }

    @Override
    public boolean checkout(String isbn){
        Book book = findBookByISBN(isbn);
        if (book != null && book.isAvailable()){
            book.setAvailable(false);
            return true;
        }
        return false;
    }

    @Override
    public boolean returnItem(String isbn){
        Book book = findBookByISBN(isbn);
        if (book != null && !book.isAvailable()){
            book.setAvailable(true);
            return true;
        }
        return false;
        
    }

    @Override
    public boolean getStatus(String isbn){
        Book book = findBookByISBN(isbn);
        return book != null && book.isAvailable();
    }

    private Book findBookByISBN(String isbn){
        for (Book book : books){
            if (book.getIsbn().equals(isbn)){
                return book;
            }
        }
        return null;
    }
}