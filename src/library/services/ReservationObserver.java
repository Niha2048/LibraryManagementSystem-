package library.services;

import library.books.Book;

public interface ReservationObserver {
    void notifyAvailable(Book book);
}
