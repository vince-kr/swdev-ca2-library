package LibrarySystem.interactor;

import LibrarySystem.library.Library;
import LibrarySystem.library.LibraryUser;
import LibrarySystem.util.io.Files;

import java.util.HashMap;

public class UsersToFile extends Interaction{
    static final String RESET = "\u001B[0m";
    static final String RED = "\u001B[31m";
    String header = "FILES\n";
    @Override
    public void requestAndResponse(Library library) {
        /*
          steps to print assets to file
          1. get all users in the system
          2. call helper method to print to csv file
        */
        System.out.println(header);
        HashMap<Integer, LibraryUser> users = library.getAllUsers();
        if (!users.isEmpty()){
            System.out.println("Printing to file ...");
            Files.printLibraryUserToFile(users,"users.csv");
        }else{
            System.out.println(RED+" No users in the system yet."+RESET);
        }

    }
}
