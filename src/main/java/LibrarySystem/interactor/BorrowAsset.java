package LibrarySystem.interactor;

import LibrarySystem.library.Library;
import LibrarySystem.library.LibraryUser;
import LibrarySystem.library.Loan;
import LibrarySystem.library.catalogue.*;

public class BorrowAsset extends AssetOperation {
    static final String RESET = "\u001B[0m";
    static final String RED = "\u001B[31m";
    static final String GREEN = "\u001B[32m";
    String header = "Borrow AN ASSET\n";

    @Override
    public void requestAndResponse(Library library) {
         /*
        Steps to borrow an asset:
        1. Get the user who is going to borrow
        2. Get the asset to borrow and check status of asset to be available
        3. Once all information has been gathered, add asset to the list of borrowed assets
            of the user.
        4. Change status,quantity of asset and set a date issued and date due
        */

        System.out.println(header);

        if (!library.hasUsers()) {
            System.out.println(RED + "Create users before performing borrowing." + RESET);
            return;
        }

        AssetsRegister availableAssets = library.getAvailableAssets();
        if (availableAssets.isEmpty()) {
            System.out.println(RED + "There are no assets available for borrowing." + RESET);
            return;
        }

        LibraryUser userWantsToBorrow = askLibraryUser(library.getAllUsers());
        AssetRegisterEntry assetEntry = askAsset(availableAssets);
        Asset assetToBorrow = assetEntry.getValue();

        // Record the loan
        library.recordLoan(new Loan(userWantsToBorrow, assetEntry));

        System.out.println(GREEN+" Asset: " + assetToBorrow.getTitle() + " borrowed by user: " + userWantsToBorrow.getName() + ", successfully."+RESET);
    }
}
