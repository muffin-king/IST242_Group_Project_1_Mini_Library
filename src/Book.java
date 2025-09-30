public class Book {
    private String name;
    private String author;
    private int year;
    private String publisher;
    private String isbn;

    public Book(String name, String author, int year, String publisher, String isbn) {
        this.name = name;
        this.author = author;
        this.year = year;
        this.publisher = publisher;
        this.isbn = isbn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getISBN() {
        return isbn;
    }

    public void setISBN(String isbn) {
        this.isbn = isbn;
    }

    //TODO
    // Return in the format: name | author | year | publisher | isbn
    public String toString() {
        return null;
    }

    //Copied from our design doc, but this method would likely be in whatever class manages the entire list of books
    public void deleteBook() {

    }
}
