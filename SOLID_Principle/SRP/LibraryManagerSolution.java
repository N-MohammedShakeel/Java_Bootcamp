package Java_Bootcamp.SOLID_Principle.SRP;// LibraryManagerSolution.java
// Demonstrates adherence to the Single Responsibility Principle (SRP)
// Responsibilities are split into separate classes: book management and email sending

// Class responsible for managing books (single responsibility)
class BookManager {
    private String[] books = new String[100];
    private int bookCount = 0;

    // Adds a book to the library
    public void addBook(String book) {
        if (bookCount < books.length) {
            books[bookCount++] = book;
            System.out.println("Added book: " + book);
        }
    }

    // Removes a book from the library
    public void removeBook(String book) {
        for (int i = 0; i < bookCount; i++) {
            if (books[i].equals(book)) {
                books[i] = books[bookCount - 1];
                books[bookCount - 1] = null;
                bookCount--;
                System.out.println("Removed book: " + book);
                break;
            }
        }
    }
}

// Class responsible for sending email notifications (single responsibility)
class EmailService {
    public void sendEmailNotification(String recipient, String message) {
        System.out.println("Sending email to " + recipient + ": " + message);
        // Simulate email sending logic
    }
}

// Main class to coordinate book management and notifications
public class LibraryManagerSolution {
    public static void main(String[] args) {
        BookManager bookManager = new BookManager();
        EmailService emailService = new EmailService();

        // Add a book and notify
        String book = "Java Programming";
        bookManager.addBook(book);
        emailService.sendEmailNotification("admin@library.com", "New book added: " + book);

        // Remove a book and notify
        bookManager.removeBook(book);
        emailService.sendEmailNotification("admin@library.com", "Book removed: " + book);
    }
}