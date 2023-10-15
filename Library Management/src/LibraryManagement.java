import java.util.Scanner;

public class LibraryManagement {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Library library = new Library();

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Add Book\n2. Remove Book\n3. Search Book\n4. Borrow Book\n5. Return Book\n6. Display All Books\n7. Add Patron\n8. Remove Patron\n9. Display All Patrons\n10. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter book title and author:");
                    String title = scanner.nextLine();
                    String author = scanner.nextLine();
                    library.addBook(new Book(title, author));
                    break;

                case 2:
                    System.out.println("Enter book title to remove:");
                    title = scanner.nextLine();
                    library.removeBook(title);
                    break;

                case 3:
                    System.out.println("Enter book title to search:");
                    title = scanner.nextLine();
                    Book found = library.searchBookByTitle(title);
                    System.out.println(found == null ? "Book not found" : found);
                    break;

                case 4:
                    System.out.println("Enter your Patron ID and book title:");
                    int patronId = scanner.nextInt();
                    scanner.nextLine();
                    title = scanner.nextLine();
                    Patron patron = library.findPatronById(patronId);
                    if (patron == null) {
                        System.out.println("Patron not found");
                        break;
                    }
                    Book bookToBorrow = library.searchBookByTitle(title);
                    if (bookToBorrow != null && !bookToBorrow.isBorrowed()) {
                        patron.borrowBook(bookToBorrow);
                        System.out.println("Book borrowed successfully!");
                    } else {
                        System.out.println("Book is either not available or already borrowed.");
                    }
                    break;

                case 5:
                    System.out.println("Enter your Patron ID and book title to return:");
                    patronId = scanner.nextInt();
                    scanner.nextLine();
                    title = scanner.nextLine();
                    patron = library.findPatronById(patronId);
                    if (patron == null) {
                        System.out.println("Patron not found");
                        break;
                    }
                    Book bookToReturn = library.searchBookByTitle(title);
                    if (bookToReturn != null && bookToReturn.isBorrowed()) {
                        patron.returnBook(bookToReturn);
                        System.out.println("Book returned successfully!");
                    } else {
                        System.out.println("Book is not borrowed or not found.");
                    }
                    break;

                case 6:
                    library.displayAllBooks();
                    break;
                case 7:
                    System.out.println("Enter patron name:");
                    String name = scanner.nextLine();
                    System.out.println("Enter patron ID (integer):");
                    int newPatronId = scanner.nextInt();
                    scanner.nextLine();
                    Patron newPatron = new Patron(name, newPatronId);
                    library.addPatron(newPatron);
                    System.out.println("Patron added successfully!");
                    break;

                case 8:
                    System.out.println("Enter patron ID to remove:");
                    patronId = scanner.nextInt();
                    scanner.nextLine();
                    library.removePatron(patronId);
                    System.out.println("Patron removed successfully!");
                    break;

                case 9:
                    library.displayAllPatrons();
                    break;

                case 10:
                    return;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
