public interface LibraryItem{
    boolean checkout(String isbn);
    boolean returnItem(String isbn);
    boolean getStatus(String isbn);
}