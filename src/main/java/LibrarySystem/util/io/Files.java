package LibrarySystem.util.io;

import java.io.*;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

import LibrarySystem.library.LibraryUser;
import LibrarySystem.library.PersonException;
import LibrarySystem.library.catalogue.*;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
public abstract class Files {
    /*
     with static methods to write to a csv file
     and read from csv files depending on the
     object in question.
     */
    static final String GREEN = "\u001B[32m";
    static final String RESET = "\u001B[0m";
    static final String DATA_PREFIX = "data/";

    /*
        Print AuthorId, AuthorName and Number of assets
        authored in a csv file
     */
    public static void printAuthorsToFile(HashMap<Integer,Author> authors, String csvFileName){
        String csvFilePath = DATA_PREFIX + csvFileName;
        StringBuilder sb = new StringBuilder();
        if (java.nio.file.Files.notExists(Path.of(csvFilePath))){
            File file = new File(csvFilePath);
            sb.append("AuthorId");
            sb.append(",");
            sb.append("AuthorName");
            sb.append(",");
            sb.append("Number of Assets");
            sb.append("\r\n");

        }
        try {
            FileWriter fr = new FileWriter(new File(csvFilePath), true);
            BufferedWriter br = new BufferedWriter(fr);
            PrintWriter writer = new PrintWriter(br);
            if (!authors.isEmpty()){

                for (Map.Entry<Integer,Author> author:authors.entrySet()){
                    sb.append(author.getKey());
                    sb.append(",");
                    sb.append(author.getValue().getName());
                    sb.append(",");
                    sb.append(author.getValue().getBooksAuthored().size());
                    sb.append("\n");
                }
                writer.write(sb.toString());
                writer.close();
                fr.close();
                br.close();
                System.out.println(GREEN+"\n\tCSV file written successfully: " + csvFilePath + RESET);
            }
            System.out.println("No authors in the system");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    /*
     Reads Authors from the csv file given
     */
    public static HashMap<Integer,Author> readAuthorCsv(String csvFile) throws PersonException {
        HashMap<Integer,Author> authors = new HashMap<>();
        try (FileReader fr = new FileReader(csvFile);
             CSVParser csvParser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(fr)) {
            for (CSVRecord csvRecord : csvParser) {
                String name = csvRecord.get("AuthorName");
                int authorId = Integer.parseInt(csvRecord.get("AuthorId"));
                authors.put(authorId,new Author(name));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return authors;
    }
    /*
     Print Book items to csv file
     */

    public static void printAssetsToFile(HashMap<Integer,Asset> assets, String csvFilePath){
        StringBuilder sb = new StringBuilder();
        if (java.nio.file.Files.notExists(Path.of(csvFilePath))){
            File file = new File(csvFilePath);
            sb.append("Id");
            sb.append(",");
            sb.append("Title");
            sb.append(",");
            sb.append("Status");
            sb.append(",");
            sb.append("Due Date");
            sb.append(",");
            sb.append("Quantity");
            sb.append("\r\n");
        }
        try {
            FileWriter fr = new FileWriter(new File(csvFilePath), true);
            BufferedWriter br = new BufferedWriter(fr);
            PrintWriter writer = new PrintWriter(br);
            if (!assets.isEmpty()){
                for (Map.Entry<Integer, Asset> asset:assets.entrySet()){
                    sb.append(asset.getKey());
                    sb.append(",");
                    sb.append(asset.getValue().getTitle());
                    sb.append(",");
                    sb.append(asset.getValue().getAvailability());
                    sb.append(",");
                    sb.append(asset.getValue().getDateDue());
                    sb.append(",");
                    sb.append(asset.getValue().getQuantity());
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
    public static void printBooksToFile(HashMap<Integer,BookAudioBook> books, String csvFilePath){
        StringBuilder sb = new StringBuilder();
        if (java.nio.file.Files.notExists(Path.of(csvFilePath))){
            File file = new File(csvFilePath);
            sb.append("Id");
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
            sb.append("Quantity");
            sb.append("\r\n");
        }
        try {
            FileWriter fr = new FileWriter(new File(csvFilePath), true);
            BufferedWriter br = new BufferedWriter(fr);
            PrintWriter writer = new PrintWriter(br);
            if (!books.isEmpty()){
                for (Map.Entry<Integer, BookAudioBook> book:books.entrySet()){
                    sb.append(book.getKey());
                    sb.append(",");
                    sb.append(book.getValue().getTitle());
                    sb.append(",");
                    sb.append(book.getValue().getIsbn());
                    sb.append(",");
                    sb.append(book.getValue().getAvailability());
                    sb.append(",");
                    sb.append(book.getValue().getPublishedYear());
                    sb.append(",");
                    sb.append(book.getValue().getAuthor().getName());
                    sb.append(",");
                    sb.append(book.getValue().getQuantity());
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
    /*
        Reads fBooks from csv file given
     */

    public static HashMap<Integer,BookAudioBook> readBookCsv(String csvFile){
        HashMap<Integer,BookAudioBook> books = new HashMap<>();
        try (FileReader fr = new FileReader(csvFile);
             CSVParser csvParser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(fr)) {
            for (CSVRecord csvRecord : csvParser) {
                int id = Integer.parseInt(csvRecord.get("Id"));
                String title = csvRecord.get("Book Title");
                String isbn = csvRecord.get("Book ISBN");
                String year = csvRecord.get("Published Year");
                String name = csvRecord.get("AuthorName");
                books.put(id, new BookAudioBook(title,isbn,year,new Author(name)));
            }
        } catch (IOException | PersonException e) {
            throw new RuntimeException(e);
        }
        return books;
    }

    /*
     Print Dissertations to csv file

     */
    public static void DissertationsToFile(HashMap<Integer, ThesisDissertation> objects,String csvFilePath){
        StringBuilder sb = new StringBuilder();
        if (java.nio.file.Files.notExists(Path.of(csvFilePath))){
            File file = new File(csvFilePath);
            sb.append("Id");
            sb.append("Title");
            sb.append(",");
            sb.append("Topic");
            sb.append(",");
            sb.append("Status");
            sb.append(",");
            sb.append("Published Year");
            sb.append(",");
            sb.append("AuthorName");
            sb.append(",");
            sb.append("OverDue");
            sb.append(",");
            sb.append("Quantity");
            sb.append(",");
            sb.append("Summary");
            sb.append("\r\n");

        }
        try {
            FileWriter fr = new FileWriter(new File(csvFilePath), true);
            BufferedWriter br = new BufferedWriter(fr);
            PrintWriter writer = new PrintWriter(br);
            if (!objects.isEmpty()){
                for (Map.Entry<Integer,ThesisDissertation> thesis:objects.entrySet()){
                    sb.append(thesis.getKey());
                    sb.append(",");
                    sb.append(thesis.getValue().getTitle());
                    sb.append(",");
                    sb.append(thesis.getValue().getTopic());
                    sb.append(",");
                    sb.append(thesis.getValue().getAvailability());
                    sb.append(",");
                    sb.append(thesis.getValue().getPublishedDate());
                    sb.append(",");
                    sb.append(thesis.getValue().getAuthor().getName());
                    sb.append(",");
                    sb.append(thesis.getValue().getOverDue());
                    sb.append(",");
                    sb.append(thesis.getValue().getQuantity());
                    sb.append(",");
                    sb.append(thesis.getValue().getSummary());
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
    /*
     Reads Dissertations from given csv file
     */
    public static HashMap<Integer, ThesisDissertation> readThesisCsv(String csvFilePath) {
        HashMap<Integer,ThesisDissertation> dissertations = new HashMap<>();
        try (FileReader fr = new FileReader(csvFilePath);
             CSVParser csvParser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(fr)) {
            for (CSVRecord csvRecord:csvParser){
                int key = Integer.parseInt(csvRecord.get(Integer.parseInt("Id")));
                String title = csvRecord.get("Title");
                String topic = csvRecord.get("Topic");
                String year = csvRecord.get("Published Year");
                String authorName = csvRecord.get("AuthorName");
                String summary = csvRecord.get("Summary");

                dissertations.put(key,new ThesisDissertation(
                        title,
                        new Author(authorName),
                        topic,
                        summary,
                        year));
            }
            System.out.println(GREEN+"\n\tDissertation objects successfully read from file: "+csvFilePath+RESET);
        } catch (IOException | PersonException e) {
            throw new RuntimeException(e);
        }
        return dissertations;

    }
    /*
        Print Cds to csv file
     */
    public static void CdsToFile(HashMap<Integer, CdDvd> objects,String csvFilePath){
        StringBuilder sb = new StringBuilder();
        if (java.nio.file.Files.notExists(Path.of(csvFilePath))){
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
                    sb.append(cd.getValue().getProducer().getName());
                    sb.append(",");
                    sb.append(cd.getValue().getAvailability());
                    sb.append(",");
                    sb.append(cd.getValue().getProductionYear());
                    sb.append(",");
                    sb.append(cd.getValue().getDirector().getName());
                    sb.append(",");
                    sb.append(cd.getValue().getPlayTime());
                    sb.append(",");
                    sb.append(cd.getValue().getOverDue());
                    sb.append(",");
                    sb.append(cd.getValue().getOverDue());
                    sb.append(",");
                    sb.append(cd.getValue().getQuantity());
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

    /*
     Read Cds from a given csv file
     */
    public static HashMap<Integer, CdDvd> readCdFromCsv(String csvFilePath){
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
                        year));
            }
            System.out.println(GREEN+"\n\tDissertation objects successfully read from file: "+csvFilePath+RESET);
        } catch (IOException | PersonException e) {
            throw new RuntimeException(e);
        }
        return cDs;
    }

    /*
        Print Users to csv file
     */
    public static void printLibraryUserToFile(HashMap<Integer, LibraryUser> users,String csvFilePath){
        StringBuilder sb = new StringBuilder();
        if (java.nio.file.Files.notExists(Path.of(csvFilePath))){
            File file = new File(csvFilePath);
            sb.append("UserId");
            sb.append(",");
            sb.append("UserName");
            sb.append(",");
            sb.append("Borrowed of Assets");
            sb.append("\r\n");

        }
        try {
            FileWriter fr = new FileWriter(new File(csvFilePath), true);
            BufferedWriter br = new BufferedWriter(fr);
            PrintWriter writer = new PrintWriter(br);
            if (!users.isEmpty()){

                for (Map.Entry<Integer,LibraryUser> user:users.entrySet()){
                    sb.append(user.getKey());
                    sb.append(",");
                    sb.append(user.getValue().getName());
                    sb.append(",");
                    sb.append(user.getValue().getBorrowedBooks().size());
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

    /*
     Read Users from a given csv file
     */
    public static HashMap<Integer,LibraryUser> readUserFromFile(String csvFilePath) throws PersonException {
        HashMap<Integer,LibraryUser> users = new HashMap<>();
        try (FileReader fr = new FileReader(csvFilePath);
             CSVParser csvParser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(fr)) {
            for (CSVRecord csvRecord : csvParser) {
                String name = csvRecord.get("UserName");
                int authorId = Integer.parseInt(csvRecord.get("UserId"));
                users.put(authorId,new LibraryUser(name));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

}
