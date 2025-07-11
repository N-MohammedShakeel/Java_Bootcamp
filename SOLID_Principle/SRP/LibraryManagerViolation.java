package Java_Bootcamp.SOLID_Principle.SRP;// LibraryManagerViolation.java
// Demonstrates a violation of the Single Responsibility Principle (SRP)
// A single class handles multiple responsibilities: managing books and sending emails

public class LibraryManagerViolation {
    // This class manages books and sends email notifications
    // Violation: Mixing book management and email sending responsibilities
    private String[] books = new String[100];
    private int bookCount = 0;

    // Adds a book to the library
    public void addBook(String book) {
        if (bookCount < books.length) {
            books[bookCount++] = book;
            System.out.println("Added book: " + book);
            // Violation: Sending email notification in the same class
            sendEmailNotification("admin@library.com", "New book added: " + book);
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
                // Violation: Sending email notification in the same class
                sendEmailNotification("admin@library.com", "Book removed: " + book);
                break;
            }
        }
    }

    // Sends an email notification (unrelated to book management)
    // Violation: This responsibility doesn't belong in LibraryManager
    private void sendEmailNotification(String recipient, String message) {
        System.out.println("Sending email to " + recipient + ": " + message);
        // Simulate email sending logic
    }

    public static void main(String[] args) {
        LibraryManagerViolation library = new LibraryManagerViolation();
        library.addBook("Java Programming");
        library.removeBook("Java Programming");
    }
}