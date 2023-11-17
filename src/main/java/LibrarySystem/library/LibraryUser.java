package LibrarySystem.library;

import LibrarySystem.library.catalogue.Asset;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class LibraryUser extends Person implements Printable<LibraryUser>{
    private ArrayList<Asset> borrowedBooks;
    static final String RESET = "\u001B[0m";
    static final String RED = "\u001B[31m";
    static final String BLUE = "\u001b[34m";
    static final String GREEN = "\u001B[32m";


    public LibraryUser(String name) throws PersonException {
        super(name);
        this.borrowedBooks = new ArrayList<>();
    }

    public ArrayList<Asset> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(ArrayList<Asset> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }

    @Override
    public String toString() {
        return String.format("UserName: %s",getName());
    }

    @Override
    public void printToFile(ArrayList<LibraryUser> objects, String filePath) {
        StringBuilder sb = new StringBuilder();
        if (Files.notExists(Path.of(filePath))){
            File file = new File(filePath);
            sb.append("UserId");
            sb.append(",");
            sb.append("UserName");
            sb.append(",");
            sb.append("Number of Books");
            sb.append(",");
            sb.append("\n");
        }

        try {
            FileWriter fr = new FileWriter(new File(filePath), true);
            BufferedWriter br = new BufferedWriter(fr);
            PrintWriter writer = new PrintWriter(br);

            if (!objects.isEmpty()){
                for (LibraryUser user:objects) {
                    sb.append(user.getName());
                    sb.append(",");
                    sb.append(((LibraryUser) user).getBorrowedBooks().size());
                    sb.append(",");
                    sb.append("\n");
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
    public ArrayList<LibraryUser> readFromCsv(String csvFile) {
        return new ArrayList<>();
    }
}
