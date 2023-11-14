package LibrarySystem.library.catalogue;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class BookAudioBook extends Asset{
    private Author author;
    private String isbn;
    private String publishedYear;
    static final String RESET = "\u001B[0m";
    static final String RED = "\u001B[31m";
    static final String BLUE = "\u001b[34m";
    static final String GREEN = "\u001B[32m";



    public BookAudioBook(int id, String title, String isbn,  String publishedYear, Author author) {
        super(id, title);
        this.isbn = isbn;
        this.publishedYear = publishedYear;
        this.author = author;

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
    public void printToFile(ArrayList<Asset> objects, String filePath) {
        StringBuilder sb = new StringBuilder();
        if (Files.notExists(Path.of(filePath))){
            File file = new File(filePath);
            sb.append("BookId");
            sb.append(",");
            sb.append("Book Title");
            sb.append(",");
            sb.append("Book ISBN");
            sb.append(",");
            sb.append("Published Year");
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
                    if (item instanceof BookAudioBook){
                        sb.append(item.getId());
                        sb.append(",");
                        sb.append(item.getTitle());
                        sb.append(",");
                        sb.append(((BookAudioBook) item).getIsbn());
                        sb.append(",");
                        sb.append(((BookAudioBook) item).author.getName());
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
