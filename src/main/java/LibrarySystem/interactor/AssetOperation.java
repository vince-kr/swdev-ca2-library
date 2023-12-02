package LibrarySystem.interactor;

import LibrarySystem.library.LibraryUser;
import LibrarySystem.library.LibraryUserRegister;
import LibrarySystem.library.catalogue.Asset;
import LibrarySystem.library.catalogue.AssetRegisterEntry;
import LibrarySystem.library.catalogue.AssetsRegister;
import LibrarySystem.util.Search;
import LibrarySystem.util.io.StandardInput;

import java.util.Map;

abstract class AssetOperation extends Interaction {
    static final String RED = "\u001B[31m";
    static final String GREEN = "\u001B[32m";
    static final String RESET = "\u001B[0m";

    static LibraryUser askLibraryUser(LibraryUserRegister allUsers) {
        String prompt = "Enter your search term -- asterisk * can be used as a wildcard: ";
        String responsePattern = "^[\\p{L} \\*\\.,'-]+$";

        LibraryUser selectedUser = null;

        while (selectedUser == null) {
            var usersToPrint = new LibraryUserRegister();
            String query = StandardInput.getValidString(prompt, responsePattern);

            for (Map.Entry<Integer, LibraryUser> userEntry : allUsers.entrySet()) {
                LibraryUser user = userEntry.getValue();
                if (Search.matchQuery(user, query))
                    usersToPrint.put(userEntry.getKey(), user);
            }

            if (usersToPrint.isEmpty()) {
                System.out.println("This search did not return any results.");
                continue;
            }

            System.out.println(usersToPrint);

            String newPrompt = "Enter the required user ID, or 0 to do another search: ";
            int userID = StandardInput.getIntInRange(newPrompt, 0, usersToPrint.getLastID());

            if (userID == 0)
                continue;

            selectedUser = allUsers.getUser(userID);
        }

        return selectedUser;
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
