package hh.sof.Bookstore.domain;

public class Book {
    private String title;
    private String author;
    private int publicationYear;
    private String isbn;
    private double price;

    public Book(String title, String author, int publicationYear, String isbn, double price) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.isbn = isbn;
        this.price = price;
    }

    public Book() {
        this.title = null;
        this.author = null;
        this.publicationYear = (Integer) null;
        this.isbn = null;
        this.price = (Double) null;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public String getIsbn() {
        return isbn;
    }

    public double getPrice() {
        return price;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book [title=" + title + ", author=" + author + ", publicationYear=" + publicationYear + ", isbn=" + isbn
                + ", price=" + price + "]";
    }
}
