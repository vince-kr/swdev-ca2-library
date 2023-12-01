package LibrarySystem.interactor;

import LibrarySystem.library.*;
import LibrarySystem.library.catalogue.Asset;
import LibrarySystem.library.catalogue.AssetsRegister;
import LibrarySystem.util.io.StandardInput;

import java.util.HashMap;

public class ListBorrowedByUser extends Interaction {
    static final String RED = "\u001B[31m";
    static final String GREEN = "\u001B[32m";
    static final String RESET = "\u001B[0m";
    String header = "ASSETS BORROWED BY USER\n";

    @Override
    public void requestAndResponse(Library library) {
        System.out.println(header);

        LibraryUser libraryUser = askLibraryUser(library);

        AssetsRegister borrowedByUser = library.getAssetsForUser(libraryUser);
        System.out.println(borrowedByUser);

        nextReference = "common-filters";
    }

    private LibraryUser askLibraryUser(Library library) {
        String allUsers = library.getAllUsers().toString();
        String prompt = "Please enter the required user ID: ";

        System.out.println(allUsers);
        if (!(allUsers.isEmpty())) {

            int userID = StandardInput.getPositiveInt(prompt, library.getLastUserID());

            LibraryUser selectedUser = library.getUser(userID);
            if (selectedUser != null) {
                return selectedUser;
            } else {
                System.out.println(RED+"User with given Id not found in the system!"+RESET);
                return askLibraryUser(library);
            }
        }
        System.out.println(RED+"No users yet in the system."+RESET);
        return null;
    }

}
