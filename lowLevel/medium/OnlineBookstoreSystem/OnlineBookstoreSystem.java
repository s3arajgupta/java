package lowLevel.medium.OnlineBookstoreSystem;

import java.util.*;

// Abstract User Class
abstract class User {
    protected String userId;
    protected String name;
    protected String email;
    protected String password;

    public User(String userId, String name, String email, String password) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public void login() {
        System.out.println(name + " logged in.");
    }

    public void logout() {
        System.out.println(name + " logged out.");
    }

    public void updateProfile(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
        System.out.println("Profile updated for user: " + this.name);
    }
}

// Customer Class (Inherits from User)
class Customer extends User {
    private ShoppingCart shoppingCart;

    public Customer(String userId, String name, String email, String password) {
        super(userId, name, email, password);
        this.shoppingCart = new ShoppingCart();
    }

    public void addReview(Book book, Review review) {
        book.addReview(review);
        System.out.println("Review added for book: " + book.getTitle());
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }
}

// Admin Class (Inherits from User)
class Admin extends User {

    public Admin(String userId, String name, String email, String password) {
        super(userId, name, email, password);
    }

    public void addBook(Inventory inventory, Book book) {
        inventory.addBook(book);
        System.out.println("Book added: " + book.getTitle());
    }

    public void removeBook(Inventory inventory, Book book) {
        inventory.removeBook(book);
        System.out.println("Book removed: " + book.getTitle());
    }

    public void updateInventory(Inventory inventory, Book book, int quantity) {
        inventory.updateStock(book, quantity);
        System.out.println("Inventory updated for book: " + book.getTitle());
    }
}

// Book Class
class Book {
    private String title;
    private String author;
    private String ISBN;
    private double price;
    private int stockQuantity;
    private List<Review> reviews;

    public Book(String title, String author, String ISBN, double price, int stockQuantity) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.reviews = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public void updateStock(int quantity) {
        this.stockQuantity += quantity;
    }

    public void addReview(Review review) {
        reviews.add(review);
    }

    public double getPrice() {
        return price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public void dummy() {
        System.out.println(author + ISBN);
    }

}

// ShoppingCart Class
class ShoppingCart {
    private Map<Book, Integer> cartItems;

    public ShoppingCart() {
        this.cartItems = new HashMap<>();
    }

    public void addBook(Book book, int quantity) {
        cartItems.put(book, cartItems.getOrDefault(book, 0) + quantity);
    }

    public void removeBook(Book book) {
        cartItems.remove(book);
    }

    public void updateQuantity(Book book, int quantity) {
        cartItems.put(book, quantity);
    }

    public double getTotalPrice() {
        return cartItems.entrySet().stream()
                .mapToDouble(entry -> entry.getKey().getPrice() * entry.getValue())
                .sum();
    }

    public Map<Book, Integer> getCartItems() {
        return cartItems;
    }
}

// Order Class
class Order {
    private String orderId;
    private List<Book> orderItems;
    private String orderStatus;
    private String paymentStatus;
    private String shipmentDetails;

    public Order(String orderId, List<Book> orderItems) {
        this.orderId = orderId;
        this.orderItems = orderItems;
        this.orderStatus = "Processing";
        this.paymentStatus = "Pending";
    }

    public void placeOrder(ShoppingCart cart) {
        this.orderItems = new ArrayList<>(cart.getCartItems().keySet());
        this.orderStatus = "Placed";
        System.out.println("Order placed with ID: " + orderId);
    }

    public void cancelOrder() {
        this.orderStatus = "Cancelled";
        System.out.println("Order cancelled with ID: " + orderId);
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void dummy() {
        System.out.println(orderItems + shipmentDetails + paymentStatus);
    }

}

// Abstract Payment Class
abstract class Payment {
    protected double amount;

    public Payment(double amount) {
        this.amount = amount;
    }

    public abstract void processPayment();
}

// CreditCardPayment Class
class CreditCardPayment extends Payment {

    public CreditCardPayment(double amount) {
        super(amount);
    }

    @Override
    public void processPayment() {
        System.out.println("Processing credit card payment of $" + amount);
    }
}

// PayPalPayment Class
class PayPalPayment extends Payment {

    public PayPalPayment(double amount) {
        super(amount);
    }

    @Override
    public void processPayment() {
        System.out.println("Processing PayPal payment of $" + amount);
    }
}

// Inventory Class
class Inventory {
    private List<Book> books;

    public Inventory() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public void updateStock(Book book, int quantity) {
        book.updateStock(quantity);
    }

    public List<Book> getBooks() {
        return books;
    }
}

// Review Class
class Review {
    private int rating;
    private String comment;

    public Review(int rating, String comment) {
        this.rating = rating;
        this.comment = comment;
    }

    public void dummy() {
        System.out.println(rating + comment);
    }

}

// Promotion Class
class Promotion {
    private String promotionCode;
    private double discountAmount;

    public Promotion(String promotionCode, double discountAmount) {
        this.promotionCode = promotionCode;
        this.discountAmount = discountAmount;
    }

    public void applyPromotion(ShoppingCart cart) {
        double total = cart.getTotalPrice();
        double discountedTotal = total - discountAmount;
        System.out.println("Promotion applied. Original Total: $" + total + ", Discounted Total: $" + discountedTotal);
    }

    public void dummy() {
        System.out.println(promotionCode);
    }

}

// Main Class to Test the Design
public class OnlineBookstoreSystem {
    public static void main(String[] args) {
        // Create inventory and add books
        Inventory inventory = new Inventory();
        Book book1 = new Book("Effective Java", "Joshua Bloch", "1234567890", 45.0, 10);
        Book book2 = new Book("Clean Code", "Robert C. Martin", "0987654321", 40.0, 5);
        inventory.addBook(book1);
        inventory.addBook(book2);

        // Create a customer and add books to their shopping cart
        Customer customer = new Customer("C001", "Alice", "alice@example.com", "password123");
        customer.getShoppingCart().addBook(book1, 2);
        customer.getShoppingCart().addBook(book2, 1);

        // Apply promotion
        Promotion promotion = new Promotion("DISCOUNT10", 10.0);
        promotion.applyPromotion(customer.getShoppingCart());

        // Place an order
        Order order = new Order("O001", new ArrayList<>(customer.getShoppingCart().getCartItems().keySet()));
        order.placeOrder(customer.getShoppingCart());

        // Process payment
        Payment payment = new CreditCardPayment(customer.getShoppingCart().getTotalPrice());
        payment.processPayment();
        order.setPaymentStatus("Paid");

        // Customer leaves a review
        Review review = new Review(5, "Excellent book!");
        customer.addReview(book1, review);

        // Admin updates inventory
        Admin admin = new Admin("A001", "Bob", "bob@example.com", "adminpass");
        admin.updateInventory(inventory, book1, 5);
    }
}
