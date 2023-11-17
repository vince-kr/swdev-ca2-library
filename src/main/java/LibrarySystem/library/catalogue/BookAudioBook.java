package LibrarySystem.library.catalogue;

import java.io.*;

import LibrarySystem.library.PersonException;
import LibrarySystem.library.PrintMap;
import LibrarySystem.library.Printable;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public class BookAudioBook extends Asset implements PrintMap<BookAudioBook> {
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
    public void printToFile(HashMap<Integer, BookAudioBook> objects, String csvFilePath) {
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
            sb.append("Id");
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
                for (Map.Entry<Integer,BookAudioBook> book:objects.entrySet()){
                    sb.append(book.getKey());
                    sb.append(",");
                    sb.append(book.getValue().getTitle());
                    sb.append(",");
                    sb.append(book.getValue().getIsbn());
                    sb.append(",");
                    sb.append(book.getValue().getStatus());
                    sb.append(",");
                    sb.append(book.getValue().getPublishedYear());
                    sb.append(",");
                    sb.append(book.getValue().author.getName());
                    sb.append(",");
                    sb.append(book.getKey());
                    sb.append(",");
                    sb.append(book.getValue().getOverDue());
                    sb.append(",");
                    sb.append(book.getValue().getQuantity());
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
    public HashMap<Integer, BookAudioBook> readFromCsv(String csvFilePath) {
        HashMap<Integer,BookAudioBook> books = new HashMap<>();
        try (FileReader fr = new FileReader(csvFilePath);
             CSVParser csvParser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(fr)) {
            for (CSVRecord csvRecord:csvParser){
                int key = Integer.parseInt(csvRecord.get(Integer.parseInt("Id")));
                String title = csvRecord.get("Book Title");
                String isbn = csvRecord.get("Book ISBN");
                String year = csvRecord.get("Published Year");
                String authorName = csvRecord.get("AuthorName");
                int qty = Integer.parseInt(csvRecord.get("Quantity"));
                books.put(key,new BookAudioBook(
                        title,
                        isbn,
                        year,
                        new Author(authorName),
                        qty));
            }
            System.out.println(GREEN+"\n\tDissertation objects successfully read from file: "+csvFilePath+RESET);
        } catch (IOException | PersonException e) {
            throw new RuntimeException(e);
        }
        return books;

    }

}
