package LibrarySystem.interactor;

import LibrarySystem.library.Library;
import LibrarySystem.library.LibraryUser;
import LibrarySystem.library.LibraryUserRegister;
import LibrarySystem.util.io.Files;

import java.util.HashMap;

public class UsersToFile extends Interaction{
    static final String RESET = "\u001B[0m";
    static final String RED = "\u001B[31m";
    static final String GREEN = "\u001B[32m";
    String header = "FILES\n";
    @Override
    public void requestAndResponse(Library library) {
        /*
          steps to print assets to file
          1. get all users in the system
          2. call helper method to print to csv file
        */
        System.out.println(header);
        //LibraryUserRegister users = library.getAllUsers();
        if (!library.getAllUsers().isEmpty()){
            System.out.println(GREEN+"Printing to file ..."+RESET);
            Files.printLibraryUserToFile(library,"users.csv");
        } else {
            System.out.println(RED+" No users in the system yet."+RESET);
        }
    }
}
