package LibrarySystem.library.catalogue;

import LibrarySystem.library.PersonException;
import LibrarySystem.library.Printable;

import java.io.*;
import LibrarySystem.library.Printable;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import java.time.LocalTime;
import java.util.ArrayList;

public class ThesisDissertation extends Asset implements Printable<ThesisDissertation> {
    private Author author;
    private String topic;
    private String summary;
    private String publishedDate;
    private int quantity;
    private LocalTime dateIssued;
    private LocalTime dateDue;
    private String overDue;
    static final String RESET = "\u001B[0m";
    static final String RED = "\u001B[31m";
    static final String BLUE = "\u001b[34m";
    static final String GREEN = "\u001B[32m";

    public ThesisDissertation(String title, Author author, String topic, String summary, String publishedDate,int quantity) {
        super(title);
        this.author = author;
        this.topic = topic;
        this.summary = summary;
        this.publishedDate = publishedDate;
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

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }


    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
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
    public String toString() {
        return String.format("Author: %s, Topic: %s, Date: %s", author.getName(),topic,getPublishedDate());
    }

    @Override
    public String getAssetType() {
        return "Thesis";
    }


    @Override
    public void printToFile(ArrayList<ThesisDissertation> objects, String csvFilePath) {
        try (FileWriter fr = new FileWriter(csvFilePath);
             CSVPrinter csvPrinter = new CSVPrinter(fr, CSVFormat.DEFAULT.withHeader(
                     "Title","Topic","Status",
                     "Published Year","AuthorName","AuthorId",
                     "OverDue","Quantity","Summary"))){
            for (ThesisDissertation thesis:objects) {

                csvPrinter.printRecord(
                        thesis.getTitle(),
                        thesis.getTopic(),
                        thesis.getStatus(),
                        thesis.getPublishedDate(),
                        thesis.author.getName(),
                        thesis.author.getId(),
                        thesis.getOverDue(),
                        thesis.getQuantity(),
                        thesis.getSummary());

            }
            System.out.println(GREEN+"\n\tCSV file written successfully: " + csvFilePath+RESET);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ArrayList<ThesisDissertation> readFromCsv(String csvFile) {
        ArrayList<ThesisDissertation> dissertations = new ArrayList<>();
        try (FileReader fr = new FileReader(csvFile);
             CSVParser csvParser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(fr)) {
            for (CSVRecord csvRecord:csvParser){
                String title = csvRecord.get("Title");
                String topic = csvRecord.get("Topic");
                String year = csvRecord.get("Published Year");
                String authorName = csvRecord.get("AuthorName");
                int authorId = Integer.parseInt(csvRecord.get("AuthorId"));
                String summary = csvRecord.get("Summary");
                int qty = Integer.parseInt(csvRecord.get("Quantity"));
                dissertations.add(new ThesisDissertation(
                        title,
                        new Author(authorId,authorName),
                        topic,
                        summary,
                        year,
                        qty));
            }
            System.out.println(GREEN+"\n\tDissertation objects successfully read from file: "+csvFile+RESET);
        } catch (IOException | PersonException e) {
            throw new RuntimeException(e);
        }
        return dissertations;

    }
}
