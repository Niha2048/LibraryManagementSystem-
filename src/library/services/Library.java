package library.services;

import library.books.Book;
import library.patrons.Patron;
import java.util.*;
import java.util.logging.Logger;

public class Library {
    private Map<String, Book> inventory = new HashMap<>();
    private Map<Integer, Patron> patrons = new HashMap<>();
    private Map<Book, List<Patron>> reservations = new HashMap<>();
    private static final Logger logger = Logger.getLogger(Library.class.getName());


    public void addBook(Book book) { inventory.put(book.toString(), book); }
    public void addPatron(Patron patron) { patrons.put(patron.hashCode(), patron); }

    public Book searchByTitle(String title) {
        return inventory.values().stream()
                .filter(b -> b.toString().contains(title))
                .findFirst().orElse(null);
    }
    public Book searchByAuthor(String author) {
        return inventory.values().stream()
            .filter(b -> b.getAuthor().equalsIgnoreCase(author))
            .findFirst().orElse(null);
    }

    public Book searchByISBN(String isbn) {
        return inventory.get(isbn); 
    }

    public List<Book> listAvailableBooks() {
        return inventory.values().stream()
            .filter(Book::isAvailable)
            .toList();
}

    public List<Book> listBorrowedBooks() {
        return inventory.values().stream()
            .filter(b -> !b.isAvailable())
            .toList();
    }
    public List<Book> recommendBooks(Patron patron, RecommendationStrategy strategy) {
        return strategy.recommendBooks(patron, new ArrayList<>(inventory.values()));
    }



    public void reserveBook(Book book, Patron patron) {
        reservations.computeIfAbsent(book, k -> new ArrayList<>()).add(patron);
        System.out.println(patron + " reserved " + book);
    }



    public void checkoutBook(Book book, Patron patron) {
        if (book.isAvailable()) {
            patron.borrowBook(book);
            logger.info(patron + " borrowed " + book);
        } else {
            logger.warning("Book not available: " + book);
        }
    }

    public void returnBook(Book book, Patron patron) {
        patron.returnBook(book);
        logger.info(patron + " returned " + book);

        if (reservations.containsKey(book)) {
            for (Patron p : reservations.get(book)) {
                p.notifyAvailable(book);
                logger.info("Notification sent to " + p + " for " + book);
            }
            reservations.remove(book);
        }
    }
}
