package library.books;

public class Book {
    private String title;
    private String author;
    private String isbn;
    private int publicationYear;
    private boolean available = true;

    public Book(String title, String author, String isbn, int publicationYear) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publicationYear = publicationYear;
    }

    public String getAuthor() { return author; }
    public String getIsbn() { return isbn; }
    public String getTitle() { return title; }


    public boolean isAvailable() { return available; }
    public void markAsBorrowed() { available = false; }
    public void markAsReturned() { available = true; }

    @Override
    public String toString() {
        return title + " by " + author + " (" + publicationYear + ")";
    }
}
