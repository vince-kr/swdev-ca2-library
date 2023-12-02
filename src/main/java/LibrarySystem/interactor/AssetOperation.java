package LibrarySystem.interactor;

import LibrarySystem.library.LibraryUser;
import LibrarySystem.library.LibraryUserRegister;
import LibrarySystem.library.catalogue.Asset;
import LibrarySystem.library.catalogue.AssetRegisterEntry;
import LibrarySystem.library.catalogue.AssetsRegister;
import LibrarySystem.util.io.StandardInput;

import java.util.Map;

abstract class AssetOperation extends Interaction {
    static final String RED = "\u001B[31m";
    static final String GREEN = "\u001B[32m";
    static final String RESET = "\u001B[0m";

    static LibraryUser askLibraryUser(LibraryUserRegister allUsers) {
        String prompt = "Please enter the required user ID: ";

        System.out.println(allUsers);

        int userID = StandardInput.getPositiveInt(prompt, allUsers.getLastID());

        LibraryUser selectedUser = allUsers.getUser(userID);
        if (selectedUser != null) {
            return selectedUser;
        } else {
            System.out.println(RED + "User with given ID not found in the system!" + RESET);
            return askLibraryUser(allUsers);
        }
    }

    static AssetRegisterEntry askAsset(AssetsRegister availableAssets) {
        String prompt = "Please enter the required asset ID: ";

        System.out.println(availableAssets);
        int assetID = StandardInput.getIntInRange(prompt, 10001, availableAssets.getGreatestID());

        for (Map.Entry<Integer, Asset> assetEntry : availableAssets.entrySet()) {
            int key = assetEntry.getKey();
            if (key == assetID) {
                return new AssetRegisterEntry(key, availableAssets.get(key));
            }
        }

        System.out.println(RED + "That asset ID is not valid. Please try again." + RESET);
        return askAsset(availableAssets);
    }
}
