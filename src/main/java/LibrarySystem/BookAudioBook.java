package LibraryCatalogue;

import java.util.Date;

public class BookAudioBook extends WrittenThing{
    private String title;
    private String isbn;

    public BookAudioBook(Date publishedDate) {
        super(publishedDate);
    }

    public BookAudioBook(Date publishedDate, String title, String isbn) {
        super(publishedDate);
        this.title = title;
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return String.format("Title: %s, ISBN: %s", title, isbn);
    }
}
