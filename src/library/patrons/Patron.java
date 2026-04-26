package library.patrons;

import library.books.Book;
import java.util.ArrayList;
import java.util.List;

import library.services.ReservationObserver;


public class Patron implements ReservationObserver{
    private String name;
    private int patronId;
    private String contactInfo;
    private List<Book> borrowedBooks = new ArrayList<>();
    private List<Book> history = new ArrayList<>();

    public Patron(String name, int patronId, String contactInfo) {
        this.name = name;
        this.patronId = patronId;
        this.contactInfo = contactInfo;
    }
    public List<Book> getBorrowingHistory() {
        return history;
    }


    public void borrowBook(Book book) {
        borrowedBooks.add(book);
        book.markAsBorrowed();
    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
        history.add(book);
        book.markAsReturned();
    }

    @Override
    public String toString() {
        return "Patron: " + name + " (ID: " + patronId + ")" + " Contact: " + contactInfo;
    }

     @Override
    public void notifyAvailable(Book book) {
        System.out.println("Notification for " + name + ": " + book + " is now available!");
    }
}
