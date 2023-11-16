package LibrarySystem.library.catalogue;

import LibrarySystem.library.PersonException;
import LibrarySystem.library.Printable;

import java.io.*;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import java.time.LocalTime;
import java.util.ArrayList;

public class CdDvd extends Asset implements Printable<CdDvd>{
    private Producer producer;
    private Director director;
    private int playTime;
    private LocalTime dateIssued;
    private LocalTime dateDue;
    private String overDue;
    private String productionYear;
    private int quantity;
    static final String RESET = "\u001B[0m";
    static final String RED = "\u001B[31m";
    static final String BLUE = "\u001b[34m";
    static final String GREEN = "\u001B[32m";

    public CdDvd(String title, Producer producer, Director director, int playTime, String productionYear, int quantity) {
        super(title);
        this.producer = producer;
        this.director = director;
        this.playTime = playTime;
        this.productionYear = productionYear;
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

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
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

    public int getPlayTime() {
        return playTime;
    }

    public void setPlayTime(int playTime) {
        this.playTime = playTime;
    }

    public String getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(String productionYear) {
        this.productionYear = productionYear;
    }

    @Override
    public String toString() {

        return String.format("Tile: %s, Producer: %s, ProductionYear: %s",getTitle(),producer.getName(),productionYear);
    }

    @Override
    public String getAssetType() {
        return "CdDvd";
    }



    @Override
    public void printToFile(ArrayList<CdDvd> objects, String csvFilePath) {
        try (FileWriter fr = new FileWriter(csvFilePath);
             CSVPrinter csvPrinter = new CSVPrinter(fr, CSVFormat.DEFAULT.withHeader(
                     "Title","ProducerName","ProducerId","Status",
                     "Production Year","DirectorName","DirectorId",
                     "PlayTime","OverDue","Quantity"))){
            for (CdDvd cd:objects) {

                csvPrinter.printRecord(
                        cd.getTitle(),
                        cd.producer.getName(),
                        cd.producer.getId(),
                        cd.getStatus(),
                        cd.getProductionYear(),
                        cd.director.getName(),
                        cd.director.getId(),
                        cd.getPlayTime(),
                        cd.getOverDue(),
                        cd.getQuantity());
            }
            System.out.println(GREEN+"\n\tCSV file written successfully: " + csvFilePath+RESET);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ArrayList<CdDvd> readFromCsv(String csvFile) {
        ArrayList<CdDvd> cDs = new ArrayList<>();
        try (FileReader fr = new FileReader(csvFile);
             CSVParser csvParser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(fr)) {
            for (CSVRecord csvRecord:csvParser){
                String title = csvRecord.get("Title");
                String prodName = csvRecord.get("ProducerName");
                int prodId = Integer.parseInt(csvRecord.get("ProducerId"));
                String year = csvRecord.get("Production Year");
                String directName = csvRecord.get("DirectorName");
                int directId = Integer.parseInt(csvRecord.get("DirectorId"));
                int playTime = Integer.parseInt(csvRecord.get("PlayTime"));
                int qty = Integer.parseInt(csvRecord.get("Quantity"));
                cDs.add(new CdDvd(title,new Producer(prodId,prodName),new Director(directId,directName),playTime,year,qty));
            }
            System.out.println(GREEN+"\n\tCD objects successfully read from file: "+csvFile+RESET);
        } catch (IOException | PersonException e) {
            throw new RuntimeException(e);
        }
        return cDs;
    }
}
