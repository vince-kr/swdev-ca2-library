package LibrarySystem.library.catalogue;

import LibrarySystem.library.Person;
import LibrarySystem.library.Printable;
import LibrarySystem.library.catalogue.BookAudioBook;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class Author extends Person implements Printable<Author> {
    private ArrayList<BookAudioBook> booksAuthored;
    static final String RESET = "\u001B[0m";
    static final String RED = "\u001B[31m";
    static final String BLUE = "\u001b[34m";
    static final String GREEN = "\u001B[32m";

    public Author(int id, String name) {
        super(id, name);
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
        return String.format("AuthorId: %d, AuthorName: %s", getId(), getName());
    }

    @Override
    public void printToFile(ArrayList<Author> objects, String filePath) {
        StringBuilder sb = new StringBuilder();
        if (Files.notExists(Path.of(filePath))){
            File file = new File(filePath);
            sb.append("AuthorId");
            sb.append(",");
            sb.append("AuthorName");
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
                for (Author author:objects) {
                    sb.append(author.getId());
                    sb.append(",");
                    sb.append(author.getName());
                    sb.append(",");
                    sb.append(((Author) author).getBooksAuthored().size());
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
}
