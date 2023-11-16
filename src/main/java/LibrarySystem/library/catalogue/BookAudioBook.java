package LibrarySystem.library.catalogue;

import java.io.*;

import LibrarySystem.library.PersonException;
import LibrarySystem.library.Printable;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import java.time.LocalTime;
import java.util.ArrayList;

public class BookAudioBook extends Asset implements Printable<BookAudioBook> {
    private Author author;
    private String isbn;
    private String publishedYear;
    private LocalTime dateIssued;
    private LocalTime dateDue;
    private String overDue;
    private int quantity;
    static final String RESET = "\u001B[0m";
    static final String RED = "\u001B[31m";
    static final String BLUE = "\u001b[34m";
    static final String GREEN = "\u001B[32m";


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

    @Override
    public void printToFile(ArrayList<BookAudioBook> objects, String csvFilePath) {
        try (FileWriter fr = new FileWriter(csvFilePath);
        CSVPrinter csvPrinter = new CSVPrinter(fr, CSVFormat.DEFAULT.withHeader(
                "Book Title","Book ISBN","Status",
                "Published Year","AuthorName","AuthorId",
                "OverDue","Quantity"))){
            for (BookAudioBook book:objects) {

               csvPrinter.printRecord(
                       book.getTitle(),
                       book.getIsbn(),
                       book.getStatus(),
                       book.getPublishedYear(),
                       book.author.getName(),
                       book.author.getId(),
                       book.getOverDue(),
                       book.getQuantity());

            }
            System.out.println(GREEN+"\n\tCSV file written successfully: " + csvFilePath+RESET);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ArrayList<BookAudioBook> readFromCsv(String csvFile) {
        ArrayList<BookAudioBook> books = new ArrayList<>();
        try (FileReader fr = new FileReader(csvFile);
            CSVParser csvParser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(fr)) {
            for (CSVRecord csvRecord:csvParser){
                String title = csvRecord.get("Book Title");
                String Isbn = csvRecord.get("Book ISBN");
                String year = csvRecord.get("Published Year");
                String authorName = csvRecord.get("AuthorName");
                int authorId = Integer.parseInt(csvRecord.get("AuthorId"));
                int qty = Integer.parseInt(csvRecord.get("Quantity"));
                books.add(new BookAudioBook(title,Isbn,year,new Author(authorId, authorName),qty));
            }
            System.out.println(GREEN+"\n\tBook objects successfully read from file: "+csvFile+RESET);
        } catch (IOException | PersonException  e) {
            throw new RuntimeException(e);
        }
        return books;
    }
}
