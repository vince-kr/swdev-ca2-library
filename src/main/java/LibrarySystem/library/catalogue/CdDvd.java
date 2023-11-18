package LibrarySystem.library.catalogue;

import LibrarySystem.library.PersonException;
import LibrarySystem.library.PrintMap;
import LibrarySystem.library.Printable;

import java.io.*;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CdDvd extends Asset implements PrintMap<CdDvd> {
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
    public void printToFile(HashMap<Integer, CdDvd> objects, String csvFilePath) {
        StringBuilder sb = new StringBuilder();
        if (Files.notExists(Path.of(csvFilePath))){
            File file = new File(csvFilePath);
            sb.append("Id");
            sb.append(",");
            sb.append("Title");
            sb.append(",");
            sb.append("ProducerName");
            sb.append(",");
            sb.append("Production Year");
            sb.append(",");
            sb.append("DirectorName");
            sb.append(",");
            sb.append("PlayTime");
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
                for (Map.Entry<Integer,CdDvd> cd: objects.entrySet()) {
                    sb.append(cd.getKey());
                    sb.append(",");
                    sb.append(cd.getValue().producer.getName());
                    sb.append(",");
                    sb.append(cd.getValue().getStatus());
                    sb.append(",");
                    sb.append(cd.getValue().getProductionYear());
                    sb.append(",");
                    sb.append(cd.getValue().director.getName());
                    sb.append(",");
                    sb.append(cd.getValue().getPlayTime());
                    sb.append(",");
                    sb.append(cd.getValue().getOverDue());
                    sb.append(",");
                    sb.append(cd.getValue().getOverDue());
                    sb.append(",");
                    sb.append(cd.getValue().getQuantity());
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
    public HashMap<Integer, CdDvd> readFromCsv(String csvFilePath) {
        HashMap<Integer,CdDvd> cDs = new HashMap<>();
        try (FileReader fr = new FileReader(csvFilePath);
             CSVParser csvParser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(fr)) {
            for (CSVRecord csvRecord:csvParser){
                int key = Integer.parseInt(csvRecord.get(Integer.parseInt("Id")));
                String title = csvRecord.get("Title");
                String producerName = csvRecord.get("ProducerName");
                String year = csvRecord.get("Published Year");
                String directorName = csvRecord.get("DirectorName");
                int playTime = Integer.parseInt(csvRecord.get("PlayTime"));
                int qty = Integer.parseInt(csvRecord.get("Quantity"));
                cDs.put(key, new CdDvd(
                        title,
                        new Producer(producerName),
                        new Director(directorName),
                        playTime,
                        year,
                        qty));
            }
            System.out.println(GREEN+"\n\tDissertation objects successfully read from file: "+csvFilePath+RESET);
        } catch (IOException | PersonException e) {
            throw new RuntimeException(e);
        }
        return cDs;

    }


}
