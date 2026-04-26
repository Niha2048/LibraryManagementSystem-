package library.services;

import library.books.Book;
import library.patrons.Patron;
import java.util.List;
import java.util.stream.Collectors;

public class AuthorBasedRecommendation implements RecommendationStrategy {
    @Override
    public List<Book> recommendBooks(Patron patron, List<Book> allBooks) {
        // Recommend books by the same author as last borrowed
        if (patron.getBorrowingHistory().isEmpty()) return List.of();
        Book lastBook = patron.getBorrowingHistory().get(patron.getBorrowingHistory().size() - 1);
        return allBooks.stream()
                .filter(b -> b.getAuthor().equalsIgnoreCase(lastBook.getAuthor()))
                .collect(Collectors.toList());
    }
}
