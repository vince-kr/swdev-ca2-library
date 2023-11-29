package LibrarySystem.interactor;

import LibrarySystem.library.Library;
import LibrarySystem.library.catalogue.Asset;
import LibrarySystem.library.catalogue.BookAudioBook;
import LibrarySystem.util.io.Files;

import java.util.HashMap;
import java.util.Map;

public class BooksToFile extends Interaction{
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
            else
                System.out.println("No book type in the assets.");
        }
        if (!allBooks.isEmpty()){
            Files.printBooksToFile(allBooks,"books.csv");
        }else{
            System.out.println("No books in the system yet.");
        }

    }
}
