package LibrarySystem.interactor;

import LibrarySystem.library.Library;
import LibrarySystem.library.PersonException;
import LibrarySystem.library.catalogue.Author;
import LibrarySystem.util.format.StringFormat;
import LibrarySystem.util.io.Files;

import java.util.HashMap;
import java.util.Map;

public class ReadFromAuthor extends Interaction{
    static final String RESET = "\u001B[0m";
    static final String RED = "\u001B[31m";
    static final String GREEN = "\u001B[32m";
    String header = "FILES\n";
    @Override
    public void requestAndResponse(Library library) {
        try {
            HashMap<Integer, Author> authors = Files.readAuthorCsv("authors.csv");
            var sb = new StringBuilder();
            sb.append(StringFormat.fixedLength(GREEN+"ID", 12));
            sb.append(StringFormat.fixedLength("AUTHOR"+RESET, 24));
            sb.append("\n");

            if (!authors.isEmpty()){
                for (Map.Entry<Integer,Author> author:authors.entrySet()){
                    sb.append(StringFormat.fixedLength(author.getKey(),12));
                    sb.append(StringFormat.fixedLength(author.getValue().getName(),24));
                    sb.append("\n");
                }
                System.out.println(sb);
            }else{
                System.out.println(RED+" No authors in the file."+RESET);
            }
        } catch (PersonException e) {
            throw new RuntimeException(e);
        }

    }
}
