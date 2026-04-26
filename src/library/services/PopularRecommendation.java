package library.services;

import library.books.Book;
import library.patrons.Patron;
import java.util.List;

// For now, just return all books (later you can track borrow counts)
public class PopularRecommendation implements RecommendationStrategy {
    @Override
    public List<Book> recommendBooks(Patron patron, List<Book> allBooks) {
        return allBooks; // placeholder for popularity logic
    }
}
