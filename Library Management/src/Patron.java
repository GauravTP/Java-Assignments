import java.util.List;
import java.util.ArrayList;
public class Patron {
    private String name;
    private int id;
    private List<Book> borrowedBooks = new ArrayList<>();

    public Patron(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public void borrowBook(Book book) {
        borrowedBooks.add(book);
        book.borrowBook(this);
    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
        book.returnBook();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

