package LibrarySystem.interactor;

import LibrarySystem.library.Library;
import LibrarySystem.library.LibraryUser;
import LibrarySystem.library.LibraryUserRegister;
import LibrarySystem.library.LoanRegister;
import LibrarySystem.library.catalogue.Asset;
import LibrarySystem.library.catalogue.AssetRegisterEntry;
import LibrarySystem.library.catalogue.AssetsRegister;
import LibrarySystem.util.io.StandardInput;

import java.util.Map;

public class ReturnAsset extends Interaction{
    static final String RESET = "\u001B[0m";
    static final String RED = "\u001B[31m";
    static final String GREEN = "\u001B[32m";
    String header = "RETURN AN ASSET\n";
    @Override
    public void requestAndResponse(Library library) {
        /*
            steps to return an asset
            1. get the user to return asset
            2. list assets borrowed by user
            3. get asset to return
            4. do return with a message
         */
        System.out.println(header);
        // get user by Id
        LibraryUser userToReturn = askLibraryUser(library);
        // list assets borrowed by user if any
        AssetsRegister assetBorrowedByUser = library.getAssetsForUser(userToReturn);
        System.out.println(assetBorrowedByUser.toString());
        //if list is empty return
        if (assetBorrowedByUser.isEmpty()){
            System.out.println(RED+"User list of borrowed assets empty."+RESET);
            return;
        }
        // get asset to return
        AssetRegisterEntry assetToReturn = askAssetToReturn(library,userToReturn);
        Asset asset  = assetToReturn.getValue();
        //
        for (int i=0; i < library.getAllLoans().size(); i++){
            if (asset == library.getAllLoans().get(i).getAsset()){
                //return asset
                library.getAllLoans().get(i).returnAsset();
                System.out.println(GREEN+"Asset: "+asset+" returned by user: "+userToReturn+RESET);
            }
        }


    }
    private LibraryUser askLibraryUser(Library library) {
        String allUsers = library.getAllUsers().toString();
        String prompt = "Please enter the required user ID: ";
        if (!(allUsers.isEmpty())) {
            System.out.println(allUsers);

            int userID = StandardInput.getPositiveInt(prompt, library.getLastUserID());

            LibraryUser selectedUser = library.getUser(userID);
            if (selectedUser != null) {
                return selectedUser;
            } else {
                System.out.println("User with given Id not found in the system!!!");
                return askLibraryUser(library);
            }
        }
        System.out.println(RED + "Create users before performing this operation " + RESET);
        return null;
    }
    private AssetRegisterEntry askAssetToReturn(Library library,LibraryUser user) {
        AssetsRegister assetBorrowedByUser = library.getAssetsForUser(user);

            String prompt = "Please enter the required asset ID: ";
            int assetID = StandardInput.getIntInRange(prompt, 10001, library.getLastAssetID());

            for (Map.Entry<Integer, Asset> assetEntry : assetBorrowedByUser.entrySet()) {
                int key = assetEntry.getKey();
                if (key == assetID) {
                    return new AssetRegisterEntry(key, assetBorrowedByUser.get(key));
                }
            }

            System.out.println("That asset ID is not valid. Please try again.");
            return askAssetToReturn(library,user);

    }
}
