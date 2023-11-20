package LibrarySystem.library.catalogue;



import java.time.LocalTime;


public class BookAudioBook extends Asset{
    private Author author;
    private String isbn;
    private String publishedYear;
    private LocalTime dateIssued;
    private LocalTime dateDue;
    private String overDue;
    private int quantity;



    public BookAudioBook(String title, String isbn, String publishedYear, Author author,int quantity) {
        super(title);
        this.isbn = isbn;
        this.publishedYear = publishedYear;
        this.author = author;
        this.quantity = quantity;
        this.dateIssued = LocalTime.parse("00:00:00.000");
        this.dateDue = LocalTime.parse("00:00:00.000");
        this.overDue = " - ";

    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalTime getDateIssued() {
        return dateIssued;
    }

    public void setDateIssued(LocalTime dateIssued) {
        this.dateIssued = dateIssued;
    }

    public LocalTime getDateDue() {
        return dateDue;
    }

    public void setDateDue(LocalTime dateDue) {
        this.dateDue = dateDue;
    }

    public String getOverDue() {
        return overDue;
    }

    public void setOverDue(String overDue) {
        this.overDue = overDue;
    }


    @Override
    public String getAssetType() {
        return "book";
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
