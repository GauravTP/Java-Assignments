public class Book {
    private String title;
    private String author;
    private boolean isBorrowed;
    private Patron borrower;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isBorrowed = false;
        this.borrower = null;
    }

    public void borrowBook(Patron patron) {
        if (!isBorrowed) {
            isBorrowed = true;
            borrower = patron;
        }
    }

    public void returnBook() {
        isBorrowed = false;
        borrower = null;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return title + " by " + author;
    }
}