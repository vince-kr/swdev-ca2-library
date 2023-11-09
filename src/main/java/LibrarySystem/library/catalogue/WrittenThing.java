package LibrarySystem;

import java.util.Date;

public abstract class WrittenThing extends Asset {
    private Date publishedDate;
    private Author author;
    private String title;

    public WrittenThing(String title) {
        super(title);
    }

    public WrittenThing(Date publishedDate, String title) {
        super(title);
        this.publishedDate = publishedDate;
    }

    public Date getPublishedDate() {
        return publishedDate;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }

    public abstract String toString();
}
