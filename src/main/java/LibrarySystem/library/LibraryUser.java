package LibrarySystem.library;

import LibrarySystem.library.catalogue.Asset;
import LibrarySystem.library.catalogue.Author;

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


    public LibraryUser(int id, String name) {
        super(id, name);
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
        return String.format("UserId: %d, UserName: %s",getId(),getName());
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
                    sb.append(user.getId());
                    sb.append(",");
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
    public void readFromCsv(String csvFile) {
        ArrayList<LibraryUser> users = new ArrayList<>();
        String line = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(csvFile));
            br.readLine();//read headers from file
            while ((line = br.readLine()) != null){
                String [] tokens = line.split(",");
                if (tokens.length > 0){
                    LibraryUser user = new LibraryUser(Integer.parseInt(tokens[0]), tokens[1]);
                    users.add(user);
                }
            }
            System.out.println("==============================================================");
            System.out.printf("%10s %10s %10s","UserId","UserName","Qty Books");
            System.out.println("==============================================================");
            for (LibraryUser auth:users) {
                String str = String.format("%10d %10s %10d", auth.getId(), auth.getName(),auth.getBorrowedBooks().size());
                System.out.println(str);
            }
            br.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
