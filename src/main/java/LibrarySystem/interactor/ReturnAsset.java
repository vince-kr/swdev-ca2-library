package LibrarySystem.interactor;

import LibrarySystem.library.*;
import LibrarySystem.library.catalogue.Asset;
import LibrarySystem.library.catalogue.AssetRegisterEntry;
import LibrarySystem.library.catalogue.AssetsRegister;

public class ReturnAsset extends AssetOperation {
    static final String RESET = "\u001B[0m";
    static final String RED = "\u001B[31m";
    static final String GREEN = "\u001B[32m";
    String header = "RETURN AN ASSET\n";

    @Override
    public void requestAndResponse(Library library) {
        /*
            steps to return an asset
            1. get the user to return asset
            2. get assets borrowed by user
            3. ask asset to return
            4. do return with a message
         */
        System.out.println(header);

        if (library.hasNoUsers()) {
            System.out.println(RED + "Create users before performing return." + RESET);
            return;
        }

        // get user by Id
        LibraryUser userDoingReturn = askLibraryUser(library.getActiveUsers());

        AssetsRegister availableAssets = library.getAssetsForUser(userDoingReturn);
        if (availableAssets.isEmpty()) {
            System.out.println(RED + "This user has not borrowed any assets. Nothing to return." + RESET);
            return;
        }

        // Get asset to return
        AssetRegisterEntry assetEntry = askAsset(availableAssets);
        Asset assetToReturn = assetEntry.getValue();

        // Get loan for selected asset and return it
        library.getLoan(userDoingReturn, assetToReturn).returnAsset();

        System.out.println(GREEN + "Asset: " + assetToReturn + " returned by user: " + userDoingReturn + RESET);
    }
}
