import java.util.Map;
import java.util.HashMap;

//This works as a manager
public class Library {
    private Map<String, Book> books = new HashMap<>();
    private Map<Integer, Patron> patrons = new HashMap<>();

    // Book methods
    public void addBook(Book book) {
        books.put(book.getTitle(), book);
    }

    public void removeBook(String title) {
        books.remove(title);
    }

    public Book searchBookByTitle(String title) {
        return books.get(title);
    }

    public void displayAllBooks() {
        for (Book book : books.values()) {
            System.out.println(book);
        }
    }

    // Patron methods
    public void addPatron(Patron patron) {
        patrons.put(patron.getId(), patron);
    }

    public void removePatron(int patronId) {
        patrons.remove(patronId);
    }

    public Patron findPatronById(int id) {
        return patrons.get(id);
    }

    public void displayAllPatrons() {
        for (Patron patron : patrons.values()) {
            System.out.println("ID: " + patron.getId() + ", Name: " + patron.getName());
        }
    }
}
