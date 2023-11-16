package LibrarySystem.library.catalogue;

import LibrarySystem.library.Printable;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
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
    public void printToFile(ArrayList<ThesisDissertation> objects, String filePath) {

    }

    @Override
    public ArrayList<ThesisDissertation> readFromCsv(String csvFile) {
        return new ArrayList<>();
    }
}
