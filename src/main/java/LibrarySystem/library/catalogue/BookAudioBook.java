package LibrarySystem.library.catalogue;

public class BookAudioBook extends Asset{
    private Author author;
    private String isbn;
    private String publishedYear;



    public BookAudioBook(int id, String title, String isbn,  String publishedYear, Author author) {
        super(id, title);
        this.isbn = isbn;
        this.publishedYear = publishedYear;
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }


    public String getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(String publishedYear) {
        this.publishedYear = publishedYear;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {

        return String.format("Title: %s, Author: %s", getTitle(),author.getName());
    }
}
