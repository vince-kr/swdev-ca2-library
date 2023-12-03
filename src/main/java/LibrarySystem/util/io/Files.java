package LibrarySystem.util.io;

import java.io.*;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

import LibrarySystem.library.*;
import LibrarySystem.library.catalogue.*;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public abstract class Files {
    /*
     with static methods to write to a csv file
     and read from csv files depending on the
     object in question.
     */
    static final String RED = "\u001B[31m";
    static final String GREEN = "\u001B[32m";
    static final String RESET = "\u001B[0m";
    static final String DATA_PREFIX = "data/";
    static private Library library;

    /*
        Print AuthorId, AuthorName and Number of assets
        authored in a csv file
     */
    public static void printCreatorsToFile(Library library, String csvFileName) {
        String csvFilePath = DATA_PREFIX + csvFileName;
        var assets = library.getAllAssets();
        var creators = library.getAllCreators();

        StringBuilder sb = new StringBuilder();
        if (java.nio.file.Files.notExists(Path.of(csvFilePath))) {
            File file = new File(csvFilePath);
            File parent = file.getParentFile();
            if (parent != null && !parent.exists() && !parent.mkdirs()) {
                throw new IllegalStateException(RED+"Couldn't create dir: "+RESET + parent);
            }
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

            for (Map.Entry<Integer, Person> creatorEntry : creators.entrySet()) {
                Person creator = creatorEntry.getValue();
                sb.append(creatorEntry.getKey());
                sb.append(",");
                sb.append(creator.getName());
                sb.append(",");
                sb.append(assets.byCreator(creator).size());
                sb.append("\n");
            }

            writer.write(sb.toString());
            writer.close();
            fr.close();
            br.close();
            System.out.println(GREEN + "\n\tCSV file written successfully: " + csvFilePath + RESET);

            System.out.println("No authors in the system");
        } catch (
                IOException e) {
            throw new RuntimeException(e);
        }

    }


    /*
     Reads Authors from the csv file given
     */
    public static HashMap<Integer, Person> readAuthorCsv(String csvFile) throws PersonException {
        HashMap<Integer, Person> authors = new HashMap<>();
        if (java.nio.file.Files.exists(Path.of(csvFile))) {
            csvFile = DATA_PREFIX + csvFile;
            try (FileReader fr = new FileReader(csvFile);
                 CSVParser csvParser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(fr)) {
                for (CSVRecord csvRecord : csvParser) {
                    String name = csvRecord.get("AuthorName");
                    int authorId = Integer.parseInt(csvRecord.get("AuthorId"));
                    authors.put(authorId, new Author(name));
                }
                System.out.println(GREEN+"Author object successfully read from file."+RESET);
            } catch (
                    IOException e) {
                throw new RuntimeException(e);
            }
            return authors;
        }
        System.out.println(RED+"File does not exits"+RESET);
        return null;
    }
    /*
     Print Book items to csv file
     */

    public static void printAssetsToFile(HashMap<Integer, Asset> assets, String csvFileName) {
        String csvFilePath = DATA_PREFIX + csvFileName;
        StringBuilder sb = new StringBuilder();
        if (java.nio.file.Files.notExists(Path.of(csvFilePath))) {
            File file = new File(csvFilePath);
            File parent = file.getParentFile();
            if (parent != null && !parent.exists() && !parent.mkdirs()) {
                throw new IllegalStateException(RED+"Couldn't create dir: "+RESET + parent);
            }
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
            if (!assets.isEmpty()) {
                for (Map.Entry<Integer, Asset> asset : assets.entrySet()) {
                    sb.append(asset.getKey());
                    sb.append(",");
                    sb.append(asset.getValue().getTitle());
                    sb.append(",");
                    sb.append(asset.getValue().getQuantity());
                    sb.append("\n");
                }

                writer.write(sb.toString());
                writer.close();
                fr.close();
                br.close();
                System.out.println(GREEN + "\n\tCSV file written successfully: " + csvFilePath + RESET);
            }
        } catch (
                IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void printBooksToFile(HashMap<Integer, BookAudioBook> books, String csvFileName) {
        String csvFilePath = DATA_PREFIX + csvFileName;
        StringBuilder sb = new StringBuilder();
        if (java.nio.file.Files.notExists(Path.of(csvFilePath))) {
            File file = new File(csvFilePath);
            File parent = file.getParentFile();
            if (parent != null && !parent.exists() && !parent.mkdirs()) {
                throw new IllegalStateException(RED+"Couldn't create dir: "+RESET + parent);
            }
            sb.append("Id");
            sb.append(",");
            sb.append("Book Title");
            sb.append(",");
            sb.append("Book ISBN");
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
            if (!books.isEmpty()) {
                for (Map.Entry<Integer, BookAudioBook> book : books.entrySet()) {
                    sb.append(book.getKey());
                    sb.append(",");
                    sb.append(book.getValue().getTitle());
                    sb.append(",");
                    sb.append(book.getValue().getIsbn());
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
                System.out.println(GREEN + "\n\tCSV file written successfully: " + csvFilePath + RESET);
            }
        } catch (
                IOException e) {
            throw new RuntimeException(e);
        }

    }
    /*
        Reads Books from csv file given
     */

    public static HashMap<Integer, BookAudioBook> readBookCsv(String csvFile) {
        HashMap<Integer, BookAudioBook> books = new HashMap<>();
        if (java.nio.file.Files.notExists(Path.of(csvFile))) {
            csvFile = DATA_PREFIX + csvFile;
            try (FileReader fr = new FileReader(csvFile);
                 CSVParser csvParser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(fr)) {
                for (CSVRecord csvRecord : csvParser) {
                    int id = Integer.parseInt(csvRecord.get("Id"));
                    String title = csvRecord.get("Book Title");
                    int quantity = Integer.parseInt(csvRecord.get("Quantity"));
                    String isbn = csvRecord.get("Book ISBN");
                    String year = csvRecord.get("Published Year");
                    String name = csvRecord.get("AuthorName");
                    books.put(id, new BookAudioBook(title, quantity, isbn, year, new Author(name)));
                }
                System.out.println(GREEN + "\n\tBook objects successfully read from file: " + csvFile + RESET);
            } catch (
                    IOException |
                    PersonException e) {
                throw new RuntimeException(e);
            }
            return books;
        }
        System.out.println(RED+"Files does not exist."+RESET);
        return null;
    }

    /*
     Print Dissertations to csv file

     */
    public static void DissertationsToFile(HashMap<Integer, ThesisDissertation> objects, String csvFileName) {
        String csvFilePath = DATA_PREFIX + csvFileName;
        StringBuilder sb = new StringBuilder();
        if (java.nio.file.Files.notExists(Path.of(csvFilePath))) {
            File file = new File(csvFilePath);
            File parent = file.getParentFile();
            if (parent != null && !parent.exists() && !parent.mkdirs()) {
                throw new IllegalStateException(RED+"Couldn't create dir: "+RESET + parent);
            }
            sb.append("Id");
            sb.append(",");
            sb.append("Title");
            sb.append(",");
            sb.append("Topic");
            sb.append(",");
            sb.append("Published Year");
            sb.append(",");
            sb.append("AuthorName");
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
            if (!objects.isEmpty()) {
                for (Map.Entry<Integer, ThesisDissertation> thesis : objects.entrySet()) {
                    sb.append(thesis.getKey());
                    sb.append(",");
                    sb.append(thesis.getValue().getTitle());
                    sb.append(",");
                    sb.append(thesis.getValue().getTopic());
                    sb.append(",");
                    sb.append(thesis.getValue().getPublishedDate());
                    sb.append(",");
                    sb.append(thesis.getValue().getAuthor().getName());
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
                System.out.println(GREEN + "\n\tCSV file written successfully: " + csvFilePath + RESET);
            }
        } catch (
                IOException e) {
            throw new RuntimeException(e);
        }

    }

    /*
     Reads Dissertations from given csv file
     */
    public static HashMap<Integer, ThesisDissertation> readThesisCsv(String csvFile) {
        HashMap<Integer, ThesisDissertation> dissertations = new HashMap<>();
        csvFile = DATA_PREFIX + csvFile;
        if (java.nio.file.Files.exists(Path.of(csvFile))) {
            try (FileReader fr = new FileReader(csvFile);
                 CSVParser csvParser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(fr)) {
                for (CSVRecord csvRecord : csvParser) {
                    int key = Integer.parseInt(csvRecord.get("Id"));
                    String title = csvRecord.get("Title");
                    String quantity = csvRecord.get("Quantity");
                    String topic = csvRecord.get("Topic");
                    String year = csvRecord.get("Published Year");
                    String authorName = csvRecord.get("AuthorName");
                    String summary = csvRecord.get("Summary");

                    dissertations.put(key, new ThesisDissertation(
                            title,
                            Integer.parseInt(quantity),
                            new Author(authorName),
                            topic,
                            summary,
                            year));
                }
                System.out.println(GREEN + "\n\tDissertation objects successfully read from file: " + csvFile + RESET);
            } catch (
                    IOException |
                    PersonException e) {
                throw new RuntimeException(e);
            }
            return dissertations;
        }
        System.out.println(RED+"File does not exist."+RESET);
        return null;

    }

    /*
        Print Cds to csv file
     */
    public static void CdsToFile(HashMap<Integer, CdDvd> objects, String csvFileName) {
        String csvFilePath = DATA_PREFIX + csvFileName;
        StringBuilder sb = new StringBuilder();
        if (java.nio.file.Files.notExists(Path.of(csvFilePath))) {
            File file = new File(csvFilePath);
            File parent = file.getParentFile();
            if (parent != null && !parent.exists() && !parent.mkdirs()) {
                throw new IllegalStateException(RED+"Couldn't create dir: "+RESET + parent);
            }
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
            if (!objects.isEmpty()) {
                for (Map.Entry<Integer, CdDvd> cd : objects.entrySet()) {
                    sb.append(cd.getKey());
                    sb.append(",");
                    sb.append(cd.getValue().getTitle());
                    sb.append(",");
                    sb.append(cd.getValue().getProducer().getName());
                    sb.append(",");
                    sb.append(cd.getValue().getProductionYear());
                    sb.append(",");
                    sb.append(cd.getValue().getDirector().getName());
                    sb.append(",");
                    sb.append(cd.getValue().getPlayTime());
                    sb.append(",");
                    sb.append(cd.getValue().getQuantity());
                    sb.append("\n");
                }
                writer.write(sb.toString());
                writer.close();
                fr.close();
                br.close();
                System.out.println(GREEN + "\n\tCSV file written successfully: " + csvFilePath + RESET);
            }
        } catch (
                IOException e) {
            throw new RuntimeException(e);
        }
    }

    /*
     Read Cds from a given csv file
     */
    public static HashMap<Integer, CdDvd> readCdFromCsv(String csvFile) {
        HashMap<Integer, CdDvd> cDs = new HashMap<>();
        csvFile = DATA_PREFIX + csvFile;
        if (java.nio.file.Files.exists(Path.of(csvFile))) {
            try (FileReader fr = new FileReader(csvFile);
                 CSVParser csvParser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(fr)) {
                for (CSVRecord csvRecord : csvParser) {
                    int key = Integer.parseInt(csvRecord.get("Id"));
                    String title = csvRecord.get("Title");
                    String quantity = csvRecord.get("Quantity");
                    String producerName = csvRecord.get("ProducerName");
                    String year = csvRecord.get("Production Year");
                    String directorName = csvRecord.get("DirectorName");
                    int playTime = Integer.parseInt(csvRecord.get("PlayTime"));
                    cDs.put(key, new CdDvd(
                            title,
                            Integer.parseInt(quantity),
                            new Producer(producerName),
                            new Director(directorName),
                            playTime,
                            year));
                }
                System.out.println(GREEN + "\n\tDissertation objects successfully read from file: " + csvFile + RESET);
            } catch (
                    IOException |
                    PersonException e) {
                throw new RuntimeException(e);
            }
            return cDs;
        }
        System.out.println(RED+"File does not exist."+RESET);
        return null;
    }

    /*
        Print Users to csv file
     */
    public static void printLibraryUserToFile(Library library, String csvFileName) {
        String csvFilePath = DATA_PREFIX + csvFileName;
        StringBuilder sb = new StringBuilder();
        var users = library.getAllUsers();
        if (java.nio.file.Files.notExists(Path.of(csvFilePath))) {
            File file = new File(csvFilePath);
            File parent = file.getParentFile();
            if (parent != null && !parent.exists() && !parent.mkdirs()) {
                throw new IllegalStateException(RED+"Couldn't create dir: "+RESET + parent);
            }
            sb.append("UserId");
            sb.append(",");
            sb.append("UserName");
            sb.append(",");
            sb.append("Borrowed Assets Count");
            sb.append("\r\n");

        }
        try {
            FileWriter fr = new FileWriter(new File(csvFilePath), true);
            BufferedWriter br = new BufferedWriter(fr);
            PrintWriter writer = new PrintWriter(br);
            if (!users.isEmpty()) {

                for (Map.Entry<Integer, LibraryUser> user : users.entrySet()) {
                    sb.append(user.getKey());
                    sb.append(",");
                    sb.append(user.getValue().getName());
                    sb.append(",");
                    sb.append(library.getAssetsForUser(user.getValue()).size());
                    sb.append("\n");
                }
                writer.write(sb.toString());
                writer.close();
                fr.close();
                br.close();
                System.out.println(GREEN + "\n\tCSV file written successfully: " + csvFilePath + RESET);
            }
        } catch (
                IOException e) {
            throw new RuntimeException(e);
        }

    }


    /*
     Read Users from a given csv file
     */
    public static HashMap<Integer, LibraryUser> readUserFromFile(String csvFile) throws PersonException {
        HashMap<Integer, LibraryUser> users = new HashMap<>();
        csvFile = DATA_PREFIX + csvFile;
        if (java.nio.file.Files.exists(Path.of(csvFile))) {
            try (FileReader fr = new FileReader(csvFile);
                 CSVParser csvParser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(fr)) {
                for (CSVRecord csvRecord : csvParser) {
                    String name = csvRecord.get("UserName");
                    int authorId = Integer.parseInt(csvRecord.get("UserId"));
                    users.put(authorId, new LibraryUser(name));
                }
                System.out.println(GREEN+"User object successfully read from file."+RESET);
            } catch (
                    IOException e) {
                throw new RuntimeException(e);
            }
            return users;
        }
        System.out.println(RED+"File does not exist."+RESET);
        return null;
    }

}
