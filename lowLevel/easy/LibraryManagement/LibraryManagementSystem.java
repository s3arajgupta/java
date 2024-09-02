package LibraryManagement;
import java.util.*;

// Enum for Book Status
enum BookStatus {
    AVAILABLE,
    ISSUED
}

// Singleton Library Class
class Library {
    private static Library instance;
    private List<Book> books;
    private List<User> users;
    private List<BorrowTransaction> borrowTransactions;

    private Library() {
        books = new ArrayList<>();
        users = new ArrayList<>();
        borrowTransactions = new ArrayList<>();
    }

    public static Library getInstance() {
        if (instance == null) {
            instance = new Library();
        }
        return instance;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public void registerUser(User user) {
        users.add(user);
    }

    public void borrowBook(User user, Book book) {
        if (book.getStatus() == BookStatus.AVAILABLE) {
            book.updateStatus(BookStatus.ISSUED);
            BorrowTransaction transaction = new BorrowTransaction(user, book);
            borrowTransactions.add(transaction);
            user.borrowBook(book);
        }
    }

    public void returnBook(User user, Book book) {
        book.updateStatus(BookStatus.AVAILABLE);
        user.returnBook(book);
    }
}

// Book Class
class Book {
    public String title;
    public String author;
    public String ISBN;
    private BookStatus status;

    public Book(String title, String author, String ISBN) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.status = BookStatus.AVAILABLE;
    }

    public BookStatus getStatus() {
        return status;
    }

    public void updateStatus(BookStatus status) {
        this.status = status;
    }
}

// Abstract User Class
abstract class User {
    protected String name;
    protected String id;
    protected List<Book> borrowedBooks;

    public User(String name, String id) {
        this.name = name;
        this.id = id;
        this.borrowedBooks = new ArrayList<>();
    }

    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }
}

// Student Class
class Student extends User {
    public Student(String name, String id) {
        super(name, id);
    }
}

// Teacher Class
class Teacher extends User {
    public Teacher(String name, String id) {
        super(name, id);
    }
}

// BorrowTransaction Class
class BorrowTransaction {
    private static int counter = 0;
    private String transactionId;
    private User user;
    private Book book;
    private Date borrowDate;
    public Date dueDate;

    public BorrowTransaction(User user, Book book) {
        this.transactionId = "TXN" + (++counter);
        this.user = user;
        this.book = book;
        this.borrowDate = new Date();
        this.dueDate = calculateDueDate();
    }

    private Date calculateDueDate() {
        // Example: set due date to 14 days after borrowing
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(borrowDate);
        calendar.add(Calendar.DAY_OF_YEAR, 14);
        return calendar.getTime();
    }

    public String getTransactionDetails() {
        return "Transaction ID: " + transactionId + ", User: " + user.name + ", Book: " + book.title + book.author + book.ISBN + dueDate;
    }
}

// Main Class to Test the Design
public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = Library.getInstance();

        // Add books
        Book book1 = new Book("Effective Java", "Joshua Bloch", "1234567890");
        Book book2 = new Book("Clean Code", "Robert C. Martin", "0987654321");
        library.addBook(book1);
        library.addBook(book2);

        // Register users
        User student = new Student("Alice", "S001");
        User teacher = new Teacher("Bob", "T001");
        library.registerUser(student);
        library.registerUser(teacher);

        // Borrow and return books
        library.borrowBook(student, book1);
        library.returnBook(student, book1);

        // Check transaction details
        BorrowTransaction transaction = new BorrowTransaction(student, book1);
        System.out.println(transaction.getTransactionDetails());
    }
}
