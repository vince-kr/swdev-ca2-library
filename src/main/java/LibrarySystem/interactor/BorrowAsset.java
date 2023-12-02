package LibrarySystem.interactor;

import LibrarySystem.library.Library;
import LibrarySystem.library.LibraryUser;
import LibrarySystem.library.LibraryUserRegister;
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

        LibraryUserRegister allUsers = library.getAllUsers();
        if (allUsers.isEmpty()) {
            System.out.println(RED + "Create users before performing borrowing " + RESET);
            return;
        }

        AssetsRegister availableAssets = library.getAvailableAssets();
        if (availableAssets.isEmpty()) {
            System.out.println(RED + "There are no assets available for borrowing." + RESET);
            return;
        }

        LibraryUser userWantsToBorrow = askLibraryUser(allUsers);
        AssetRegisterEntry assetEntry = askAssetToBorrow(availableAssets);
        Asset assetToBorrow = assetEntry.getValue();

        // Record the loan
        library.recordLoan(new Loan(userWantsToBorrow, assetEntry));

        System.out.println(GREEN+" Asset: " + assetToBorrow.getTitle() + " borrowed by user: " + userWantsToBorrow.getName() + ", successfully."+RESET);
    }

    private LibraryUser askLibraryUser(LibraryUserRegister allUsers) {
        String prompt = "Please enter the required user ID: ";

        System.out.println(allUsers);

        int userID = StandardInput.getPositiveInt(prompt, allUsers.getLastID());

        LibraryUser selectedUser = allUsers.getUser(userID);
        if (selectedUser != null) {
            return selectedUser;
        }
        else {
            System.out.println("User with given Id not found in the system!!!");
            return askLibraryUser(allUsers);
        }
    }

    private AssetRegisterEntry askAssetToBorrow(AssetsRegister availableAssets) {
        String prompt = "Please enter the required asset ID: ";

        System.out.println(availableAssets);
        int assetID = StandardInput.getIntInRange(prompt, 10001, availableAssets.getGreatestID());

        for (Map.Entry<Integer, Asset> assetEntry : availableAssets.entrySet()) {
            int key = assetEntry.getKey();
            if (key == assetID) {
                return new AssetRegisterEntry(key, availableAssets.get(key));
            }
        }

        System.out.println("That asset ID is not valid. Please try again.");
        return askAssetToBorrow(availableAssets);
    }

}
