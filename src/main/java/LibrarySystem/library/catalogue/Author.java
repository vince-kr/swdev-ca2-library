package LibrarySystem.library.catalogue;

import LibrarySystem.library.Person;
import LibrarySystem.library.PersonException;
import LibrarySystem.library.Printable;

import java.io.*;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class Author extends Person implements Printable<Author> {
    private ArrayList<BookAudioBook> booksAuthored;
    static final String RESET = "\u001B[0m";
    static final String RED = "\u001B[31m";
    static final String BLUE = "\u001b[34m";
    static final String GREEN = "\u001B[32m";

    public Author(int id, String name) throws PersonException {
        super(name);
        this.booksAuthored = new ArrayList<>();
    }

    public ArrayList<BookAudioBook> getBooksAuthored() {
        return booksAuthored;
    }

    public void setBooksAuthored(ArrayList<BookAudioBook> booksAuthored) {
        this.booksAuthored = booksAuthored;
    }

    @Override
    public String toString() {
        return String.format("AuthorName: %s", getName());
    }

    @Override
    public void printToFile(ArrayList<Author> objects, String csvFilePath) {
        StringBuilder sb = new StringBuilder();
        if (Files.notExists(Path.of(csvFilePath))){
            File file = new File(csvFilePath);
            sb.append("AuthorId");
            sb.append(",");
            sb.append("AuthorName");
            sb.append(",");
            sb.append("Number of Assets");
            sb.append(",");
            sb.append("\r\n");

        }

        try {
            FileWriter fr = new FileWriter(new File(csvFilePath), true);
            BufferedWriter br = new BufferedWriter(fr);
            PrintWriter writer = new PrintWriter(br);
            if (!objects.isEmpty()){
                for (Author object:objects) {
                    sb.append(object.getName());
                    sb.append(",");
                    sb.append(((Author) object).getBooksAuthored().size());
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
    public ArrayList<Author> readFromCsv(String csvFile) {
        ArrayList<Author> authors = new ArrayList<>();
        try (FileReader fr = new FileReader(csvFile);
             CSVParser csvParser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(fr)) {
            for (CSVRecord csvRecord : csvParser) {
                int authorId = Integer.parseInt(csvRecord.get("AuthorId"));
                String name = csvRecord.get("AuthorName");
                authors.add(new Author(authorId, name));
            }
            System.out.println(GREEN+"\n\tAuthor objects successfully read from file: "+csvFile+RESET);
        } catch (IOException | PersonException e) {
            throw new RuntimeException(e);
        }

        return authors;
    }
}
