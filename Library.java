import java.io.*;
import java.util.ArrayList;

public class Library {

    private ArrayList<Book> books = new ArrayList<>();
    private final String FILE_NAME = "books.dat";

    public Library() {
        loadBooks();
    }

    // Add book
    public void addBook(Book book) {
        books.add(book);
        saveBooks();
    }

    // Get all books
    public ArrayList<Book> getBooks() {
        return books;
    }

    // Search by Book ID
    // Used when adding a book to check duplicate ID
    public Book searchBook(int id) {

        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }

        return null;
    }

    // Search by Book Name
    public Book searchBook(String title) {

        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title.trim())) {
                return book;
            }
        }

        return null;
    }

    // Issue book by name
    public boolean issueBook(String title) {

        Book book = searchBook(title);

        if (book != null && book.getAvailableCopies() > 0) {
            book.issueCopy();
            saveBooks();
            return true;
        }

        return false;
    }

    // Return book by name
    public boolean returnBook(String title) {

        Book book = searchBook(title);

        if (book != null &&
                book.getAvailableCopies() < book.getTotalCopies()) {

            book.returnCopy();
            saveBooks();
            return true;
        }

        return false;
    }

    // Remove book by name
    public boolean removeBook(String title) {

        Book book = searchBook(title);

        if (book != null && book.getIssuedCopies() == 0) {
            books.remove(book);
            saveBooks();
            return true;
        }

        return false;
    }

    // Save books to file
    private void saveBooks() {

        try {

            ObjectOutputStream out =
                    new ObjectOutputStream(
                            new FileOutputStream(FILE_NAME)
                    );

            out.writeObject(books);
            out.close();

        } catch (IOException e) {

            System.out.println("Error saving books.");
        }
    }

    // Load books from file
    @SuppressWarnings("unchecked")
    private void loadBooks() {

        try {

            ObjectInputStream in =
                    new ObjectInputStream(
                            new FileInputStream(FILE_NAME)
                    );

            books = (ArrayList<Book>) in.readObject();

            in.close();

        } catch (FileNotFoundException e) {

            books = new ArrayList<>();

        } catch (IOException | ClassNotFoundException e) {

            books = new ArrayList<>();
        }
    }
}
