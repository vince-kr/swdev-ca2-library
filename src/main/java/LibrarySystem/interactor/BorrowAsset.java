package LibrarySystem.interactor;

import LibrarySystem.library.Library;
import LibrarySystem.library.LibraryUser;
import LibrarySystem.library.Loan;
import LibrarySystem.library.catalogue.*;
import LibrarySystem.util.io.StandardInput;

import java.time.LocalDateTime;
import java.util.Objects;

public class BorrowAsset extends Interaction {

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

        LibraryUser userWantsToBorrow = askLibraryUser(library);
        Asset assetToBorrow = askAssetToBorrow(library);

        // Record the loan
        library.recordLoan(new Loan(userWantsToBorrow, assetToBorrow));

        // do borrowing here
        assetToBorrow.setAvailability(false);
        assetToBorrow.setDateIssued(LocalDateTime.now());
        assetToBorrow.setDateDue(LocalDateTime.now().plusHours(24));

        //add asset to borrowed user assets
        userWantsToBorrow.setBorrowedAssets(assetToBorrow);

        System.out.println(" Asset: " + assetToBorrow.getTitle() + " borrowed by user: " + userWantsToBorrow.getName() + ", successfully.");
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

    private Asset askAssetToBorrow(Library library) {
        String allAssets = library.getAllAssets().toString();
        String prompt = "Please enter the required asset ID: ";

        System.out.println(allAssets);
        int assetID = StandardInput.getIntInRange(prompt, 10000, library.getLastAssetID());

        Asset selectedAsset = library.getAsset(assetID);
        return Objects.requireNonNullElseGet(selectedAsset, () -> askAssetToBorrow(library));
    }

}
