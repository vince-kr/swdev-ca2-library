package LibrarySystem.interactor;

import LibrarySystem.library.Library;
import LibrarySystem.library.PersonException;
import LibrarySystem.library.catalogue.BookAudioBook;
import LibrarySystem.util.format.StringFormat;
import LibrarySystem.util.io.Files;

import java.util.HashMap;
import java.util.Map;

public class ReadFromBook extends Interaction{
    static final String RESET = "\u001B[0m";
    static final String RED = "\u001B[31m";
    static final String GREEN = "\u001B[32m";
    String header = "FILES\n";
    @Override
    public void requestAndResponse(Library library) {
            HashMap<Integer, BookAudioBook> books = Files.readBookCsv("books.csv");
            if (!(books == null)) {
                var sb = new StringBuilder();
                sb.append(StringFormat.fixedLength(GREEN + "ID", 12));
                sb.append(StringFormat.fixedLength("TITLE", 24));
                sb.append(StringFormat.fixedLength("ISBN", 15));
                sb.append(StringFormat.fixedLength("YEAR", 12));
                sb.append(StringFormat.fixedLength("AUTHOR", 24));
                sb.append(StringFormat.fixedLength("QUANTITY" + RESET, 12));
                sb.append("\n");
                if (!books.isEmpty()) {
                    for (Map.Entry<Integer, BookAudioBook> book : books.entrySet()) {
                        sb.append(StringFormat.fixedLength(book.getKey(), 12));
                        sb.append(StringFormat.fixedLength(book.getValue().getTitle(), 24));
                        sb.append(StringFormat.fixedLength(book.getValue().getIsbn(), 15));
                        sb.append(StringFormat.fixedLength(book.getValue().getPublishedYear(), 12));
                        sb.append(StringFormat.fixedLength(book.getValue().getAuthor().getName(), 24));
                        sb.append(StringFormat.fixedLength(book.getValue().getQuantity(), 12));
                        sb.append("\n");
                    }
                    System.out.println(sb);
                } else {
                    System.out.println(RED + "No books from file." + RESET);
                }

            }

    }
}
