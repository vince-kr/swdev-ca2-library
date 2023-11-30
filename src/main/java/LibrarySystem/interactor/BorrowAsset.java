package LibrarySystem.interactor;

import LibrarySystem.library.Library;
import LibrarySystem.library.LibraryUser;
import LibrarySystem.library.Loan;
import LibrarySystem.library.catalogue.*;
import LibrarySystem.util.io.StandardInput;

import java.util.Map;

public class BorrowAsset extends Interaction {
    static final String RESET = "\u001B[0m";
    static final String RED = "\u001B[31m";
    static final String GREEN = "\u001B[32m";
    String header = "Borrow AN ASSET\n";
    @Override
    public void requestAndResponse(Library library) {
         /*
        Steps to borrow an asset:
        1. Get the user who is going to borrow
        2.  Get the asset to borrow and check status of asset to be available
        3. Once all information has been gathered, add asset to the list of borrowed assets
            of the user.
        4. Change status,quantity of asset and set a date issued and date due
        */

        System.out.println(header);
        if (!library.getAllUsers().isEmpty()) {
            LibraryUser userWantsToBorrow = askLibraryUser(library);
            AssetRegisterEntry assetEntry = askAssetToBorrow(library);
            Asset assetToBorrow = assetEntry.getValue();

            // Check that the asset is available
            if (assetToBorrow.getQuantity() < library.getLoansOneAsset(assetToBorrow)) {
                System.out.println(RED+"Unfortunately this title is loaned out."+RESET);
                System.out.println(RED+"Borrowing is not possible."+RESET);
                return;
            }

            // If available, record the loan
            library.recordLoan(new Loan(userWantsToBorrow, assetEntry));

            //add asset to borrowed user assets
            userWantsToBorrow.setBorrowedAssets(assetToBorrow);

            System.out.println(GREEN+" Asset: " + assetToBorrow.getTitle() + " borrowed by user: " + userWantsToBorrow.getName() + ", successfully."+RESET);
        }
        System.out.println(RED+"Create users before performing borrowing "+RESET);
    }

    private LibraryUser askLibraryUser(Library library) {
        String allUsers = library.getAllUsers().toString();
        String prompt = "Please enter the required user ID: ";

        System.out.println(allUsers);

        int userID = StandardInput.getPositiveInt(prompt, library.getLastUserID());

        LibraryUser selectedUser = library.getUser(userID);
        if (selectedUser != null) {
            return selectedUser;
        }
        else {
            System.out.println("User with given Id not found in the system!!!");
            return askLibraryUser(library);
        }
    }

    private AssetRegisterEntry askAssetToBorrow(Library library) {
        AssetsRegister allAssets = library.getAllAssets();
        String prompt = "Please enter the required asset ID: ";

        System.out.println(allAssets);
        int assetID = StandardInput.getIntInRange(prompt, 10000, library.getLastAssetID());

        for (Map.Entry<Integer, Asset> assetEntry : allAssets.entrySet()) {
            int key = assetEntry.getKey();
            if (key == assetID) {
                return new AssetRegisterEntry(key, allAssets.get(key));
            }
        }

        System.out.println("That asset ID is not valid. Please try again.");
        return askAssetToBorrow(library);
    }

}
