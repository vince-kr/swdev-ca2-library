package LibrarySystem.library.catalogue;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class ThesisDissertation extends Asset{
    private Author author;
    private String topic;
    private String summary;
    private String publishedDate;
    static final String RESET = "\u001B[0m";
    static final String RED = "\u001B[31m";
    static final String BLUE = "\u001b[34m";
    static final String GREEN = "\u001B[32m";

    public ThesisDissertation(int id, String title, Author author, String topic, String summary, String publishedDate) {
        super(id, title);
        this.author = author;
        this.topic = topic;
        this.summary = summary;
        this.publishedDate = publishedDate;
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

    @Override
    public String toString() {
        return String.format("Author: %s, Topic: %s, Date: %s", author.getName(),topic,getPublishedDate());
    }

    @Override
    public void printToFile(ArrayList<Asset> objects, String filePath) {
        StringBuilder sb = new StringBuilder();
        if (Files.notExists(Path.of(filePath))){
            File file = new File(filePath);
            sb.append("ThesisId");
            sb.append(",");
            sb.append("Thesis Title");
            sb.append(",");
            sb.append("Thesis Topic");
            sb.append(",");
            sb.append("Published Date");
            sb.append(",");
            sb.append("AuthorName");
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
                    if (item instanceof ThesisDissertation){
                        sb.append(item.getId());
                        sb.append(",");
                        sb.append(item.getTitle());
                        sb.append(",");
                        sb.append(((ThesisDissertation) item).getTopic());
                        sb.append(",");
                        sb.append(((ThesisDissertation) item).publishedDate);
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
