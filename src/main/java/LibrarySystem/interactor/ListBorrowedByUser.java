package LibrarySystem.interactor;

import LibrarySystem.library.*;
import LibrarySystem.library.catalogue.AssetsRegister;

public class ListBorrowedByUser extends AssetOperation {
    String header = "ASSETS BORROWED BY USER\n";

    @Override
    public void requestAndResponse(Library library) {
        nextReference = "common-filters";

        System.out.println(header);
        if (library.hasNoUsers()) {
            System.out.println(RED + "No library users exist in the system." + RESET);
            return;
        }

        LibraryUser libraryUser = askLibraryUser(library.getActiveUsers());
        AssetsRegister borrowedByUser = library.getAssetsForUser(libraryUser);
        System.out.println(borrowedByUser);
    }
}
