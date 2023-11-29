package LibrarySystem.interactor;

import LibrarySystem.library.Library;
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

        var sb = new StringBuilder();
        sb.append("=======================================================================\n");
        sb.append(StringFormat.fixedLength(GREEN+"ID",15));
        sb.append(StringFormat.fixedLength("TITLE",15));
        sb.append(StringFormat.fixedLength("ISBN",15));
        sb.append(StringFormat.fixedLength("YEAR",15));
        sb.append(StringFormat.fixedLength("AUTHOR"+RESET,15));
        sb.append("\n");
        sb.append("=======================================================================\n");


        if (!books.isEmpty()){
           for (Map.Entry<Integer,BookAudioBook> book:books.entrySet()){
               sb.append(StringFormat.fixedLength(book.getKey(),15));
               sb.append(StringFormat.fixedLength(book.getValue().getTitle(),15));
               sb.append(StringFormat.fixedLength(book.getValue().getIsbn(),15));
               sb.append(StringFormat.fixedLength(book.getValue().getPublishedYear(),15));
               sb.append(StringFormat.fixedLength(book.getValue().getAuthor().getName(),15));
               System.out.println(sb);
           }
        }else{
            System.out.println(RED+"The File is empty."+RESET);
        }


    }
}
