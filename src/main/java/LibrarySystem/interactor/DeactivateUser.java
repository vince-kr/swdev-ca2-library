package LibrarySystem.interactor;

import LibrarySystem.library.*;

public class DeactivateUser extends AssetOperation {
    static final String RESET = "\u001B[0m";
    static final String RED = "\u001B[31m";
    static final String GREEN = "\u001B[32m";
    String header = "DEACTIVATE user";

    @Override
    public void requestAndResponse(Library library) {
        nextReference = "manage-users";

        System.out.println(header);

        if (library.hasNoUsers()) {
            System.out.println(RED + "There are no users in the system!" + RESET);
            return;
        }

        askLibraryUser(library.getActiveUsers()).deactivate();

        System.out.println(GREEN + "User deactivated." + RESET);
    }
}
