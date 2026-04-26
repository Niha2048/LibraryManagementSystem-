package library;

import library.books.Book;
import library.patrons.Patron;
import library.services.AuthorBasedRecommendation;
import library.services.Library;
import library.services.PopularRecommendation;
import java.util.logging.*;

public class LibraryMain {
    public static void main(String[] args) {
        try {
            LogManager.getLogManager().reset();
            Logger rootLogger = Logger.getLogger("");
            FileHandler fileHandler = new FileHandler("library.log", true);
            fileHandler.setFormatter(new SimpleFormatter());
            rootLogger.addHandler(fileHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        Library library = new Library();

        Book b1 = new Book("Effective Java", "Joshua Bloch", "12345", 2018);
        Book b2 = new Book("Clean Code", "Robert C. Martin", "67890", 2008);
        Patron p1 = new Patron("Alice", 1, "alice@example.com");
        Patron p2 = new Patron("Bob", 2, "bob@example.com");


        library.addBook(b1);
        library.addBook(b2);
        library.addPatron(p1);
        library.addPatron(p2);

        library.checkoutBook(b1, p1);
        library.reserveBook(b1, p2); // Bob reserves the book
        library.returnBook(b1, p1);
        System.out.println(p1.getBorrowingHistory());

        System.out.println("Recommendations for Alice (Author-based): " +
        library.recommendBooks(p1, new AuthorBasedRecommendation()));

        System.out.println("Recommendations for Alice (Popular): " +
        library.recommendBooks(p1, new PopularRecommendation()));

        System.out.println("Search by Author: " + library.searchByAuthor("Joshua Bloch"));
        System.out.println("Available Books: " + library.listAvailableBooks());
        System.out.println("Borrowed Books: " + library.listBorrowedBooks());
        

    }
}
