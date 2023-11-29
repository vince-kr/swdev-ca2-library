package LibrarySystem.interactor;

import LibrarySystem.library.Library;
import LibrarySystem.library.catalogue.Author;
import LibrarySystem.util.io.Files;

import java.util.HashMap;

public class AuthorsToFile extends Interaction{
    String header = "FILES\n";
    @Override
    public void requestAndResponse(Library library) {
        /*
         steps to print authors to csv file
         1. get all the authors of the system
         2. call helper method to print csv file
         */
        System.out.println(header);

        HashMap<Integer, Author> authors = library.getAllAuthors();
        if (!authors.isEmpty())
            Files.printAuthorsToFile(authors,"authors.csv");
        else
            System.out.println("No authors yet in the system");
    }
}
