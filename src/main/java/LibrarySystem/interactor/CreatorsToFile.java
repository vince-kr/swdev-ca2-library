package LibrarySystem.interactor;

import LibrarySystem.library.Library;
import LibrarySystem.library.Person;
import LibrarySystem.util.io.Files;

import java.util.HashMap;

public class CreatorsToFile extends Interaction{
    String header = "FILES\n";
    static final String RESET = "\u001B[0m";
    static final String RED = "\u001B[31m";
    static final String GREEN = "\u001B[32m";
    @Override
    public void requestAndResponse(Library library) {
        /*
         steps to print authors to csv file
         1. get all the authors of the system
         2. call helper method to print csv file
         */
        System.out.println(header);

        if (!library.getAllCreators().isEmpty()) {
            System.out.println("Printing to file ...");
            Files.printCreatorsToFile(library, "authors.csv");
        } else {
            System.out.println(RED+"No authors yet in the system"+RESET);
        }
    }
}
