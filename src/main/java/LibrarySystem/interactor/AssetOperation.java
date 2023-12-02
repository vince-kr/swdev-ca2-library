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
        LibraryUser selectedUser = null;

        while (selectedUser == null) {
            LibraryUserRegister filteredUsers = filterLibraryUsers(allUsers);
            selectedUser = chooseLibraryUser(filteredUsers);
        }

        return selectedUser;
    }

    private static LibraryUserRegister filterLibraryUsers(LibraryUserRegister allUsers) {
        var filteredUsers = new LibraryUserRegister();

        String prompt = "Enter your search term -- asterisk * can be used as a wildcard: ";
        String responsePattern = "^[\\p{L} \\*\\.,'-]+$";
        String query = StandardInput.getValidString(prompt, responsePattern);

        for (Map.Entry<Integer, LibraryUser> userEntry : allUsers.entrySet()) {
            LibraryUser user = userEntry.getValue();
            if (Search.matchQuery(user, query))
                filteredUsers.put(userEntry.getKey(), user);
        }

        if (filteredUsers.isEmpty()) {
            System.out.println("This search did not return any results.");
            filterLibraryUsers(allUsers);
        }

        return filteredUsers;
    }

    private static LibraryUser chooseLibraryUser(LibraryUserRegister filteredUsers) {
        String prompt = "Enter the required user ID, or 0 to do another search: ";

        System.out.println(filteredUsers);
        int userID = StandardInput.getIntInRange(prompt, 0, filteredUsers.getLastID());

        if (userID == 0)
            return null;

        LibraryUser selectedUser = filteredUsers.getUser(userID);
        if (selectedUser == null) {
            System.out.println(RED + "No user with that ID exists!" + RESET);
            return chooseLibraryUser(filteredUsers);
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
