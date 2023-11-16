package LibrarySystem.library.catalogue;

import java.io.*;

import LibrarySystem.library.PersonException;
import LibrarySystem.library.Printable;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import java.nio.file.Files;
import java.nio.file.Path;
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
        StringBuilder sb = new StringBuilder();
        if (Files.notExists(Path.of(csvFilePath))){
            File file = new File(csvFilePath);
            sb.append("Book Title");
            sb.append(",");
            sb.append("Book ISBN");
            sb.append(",");
            sb.append("Status");
            sb.append(",");
            sb.append("Published Year");
            sb.append(",");
            sb.append("AuthorName");
            sb.append(",");
            sb.append("AuthorId");
            sb.append(",");
            sb.append("OverDue");
            sb.append(",");
            sb.append("Quantity");
            sb.append(",");
            sb.append("\r\n");

        }
        try {
            FileWriter fr = new FileWriter(new File(csvFilePath), true);
            BufferedWriter br = new BufferedWriter(fr);
            PrintWriter writer = new PrintWriter(br);
            if (!objects.isEmpty()){
                for (BookAudioBook book:objects) {
                    sb.append(book.getTitle());
                    sb.append(",");
                    sb.append(book.getIsbn());
                    sb.append(",");
                    sb.append(book.getStatus());
                    sb.append(",");
                    sb.append(book.getPublishedYear());
                    sb.append(",");
                    sb.append(book.author.getName());
                    sb.append(",");
                    sb.append(book.author.getId());
                    sb.append(",");
                    sb.append(book.getOverDue());
                    sb.append(",");
                    sb.append(book.getQuantity());
                    sb.append(",");
                    sb.append("\n");
                }
                writer.write(sb.toString());
                writer.close();
                fr.close();
                br.close();
                System.out.println(GREEN+"\n\tCSV file written successfully: " + csvFilePath+RESET);
            }
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
