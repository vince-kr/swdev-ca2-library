package LibrarySystem.interactor;

import LibrarySystem.library.Library;
import LibrarySystem.library.catalogue.Asset;
import LibrarySystem.library.catalogue.BookAudioBook;
import LibrarySystem.util.io.Files;

import java.util.HashMap;
import java.util.Map;

public class BooksToFile extends Interaction{
    static final String RESET = "\u001B[0m";
    static final String RED = "\u001B[31m";

    static final String GREEN = "\u001B[32m";
    String header = "FILES\n";
    @Override
    public void requestAndResponse(Library library) {
        /*
            steps to print assets to file
            1. get all books in the system
            2. call helper method to print to csv file
         */
        System.out.println(header);
        HashMap<Integer, BookAudioBook> allBooks = new HashMap<>();
        for (Map.Entry<Integer, Asset> asset:library.getAllAssets().entrySet()){
            if (asset.getValue() instanceof BookAudioBook)
            allBooks.put(asset.getKey(), (BookAudioBook) asset.getValue());

        }
        if (!allBooks.isEmpty()){
            System.out.println(GREEN+"Printing to file ..."+RESET);
            Files.printBooksToFile(allBooks,"books.csv");
        }else{
            System.out.println(RED+" No books in the system yet."+RESET);
        }

    }
}
