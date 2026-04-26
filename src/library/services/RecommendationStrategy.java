package library.services;

import library.books.Book;
import library.patrons.Patron;
import java.util.List;

public interface RecommendationStrategy {
    List<Book> recommendBooks(Patron patron, List<Book> allBooks);
}
