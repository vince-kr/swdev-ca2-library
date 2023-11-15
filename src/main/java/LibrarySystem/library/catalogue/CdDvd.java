package LibrarySystem.library.catalogue;

import LibrarySystem.library.Printable;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class CdDvd extends Asset{
    private Producer producer;
    private Director director;
    private int playTime;
    private String productionYear;
    static final String RESET = "\u001B[0m";
    static final String RED = "\u001B[31m";
    static final String BLUE = "\u001b[34m";
    static final String GREEN = "\u001B[32m";

    public CdDvd(String title, Producer producer, Director director, int playTime, String productionYear) {
        super(title);
        this.producer = producer;
        this.director = director;
        this.playTime = playTime;
        this.productionYear = productionYear;
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
    public void printToFile(ArrayList<Asset> objects, String filePath) {
        StringBuilder sb = new StringBuilder();
        if (Files.notExists(Path.of(filePath))){
            File file = new File(filePath);
            sb.append("CdDvdId");
            sb.append(",");
            sb.append("CdDvd Title");
            sb.append(",");
            sb.append("Production Year");
            sb.append(",");
            sb.append("ProducerName");
            sb.append(",");
            sb.append("DirectorName");
            sb.append(",");
            sb.append("PlayTime");
            sb.append(",");
            sb.append("Status");
            sb.append(",");
            sb.append("\n");
        }

        try {
            FileWriter fr = new FileWriter(new File(filePath), true);
            BufferedWriter br = new BufferedWriter(fr);
            PrintWriter writer = new PrintWriter(br);

            if (!objects.isEmpty()){
                for (Asset item:objects) {
                    if (item instanceof CdDvd){
                        sb.append(item.getTitle());
                        sb.append(",");
                        sb.append(((CdDvd) item).productionYear);
                        sb.append(",");
                        sb.append(((CdDvd) item).producer.getId());
                        sb.append(",");
                        sb.append(((CdDvd) item).director.getName());
                        sb.append(",");
                        sb.append(((CdDvd) item).getPlayTime());
                        sb.append(",");
                        sb.append(item.getStatus());
                        sb.append(",");
                        sb.append("\n");
                    }
                }
                writer.write(sb.toString());
                writer.close();
                fr.close();
                br.close();
                System.out.println(GREEN+" Successfully written to file!"+RESET);

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void readFromCsv(String csvFile) {

    }
}
