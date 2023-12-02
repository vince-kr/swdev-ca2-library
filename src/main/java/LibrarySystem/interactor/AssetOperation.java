package LibrarySystem.interactor;

import LibrarySystem.library.LibraryUser;
import LibrarySystem.library.LibraryUserRegister;
import LibrarySystem.library.Person;
import LibrarySystem.library.catalogue.Asset;
import LibrarySystem.library.catalogue.AssetRegisterEntry;
import LibrarySystem.library.catalogue.AssetsRegister;
import LibrarySystem.util.Search;
import LibrarySystem.util.io.StandardInput;

import java.util.HashMap;
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

    static LibraryUserRegister searchLibraryUser(LibraryUserRegister allUsers){
        LibraryUserRegister filteredUsers = filterLibraryUsers(allUsers);
        System.out.println(filteredUsers);
        return filteredUsers;
    }

    static AssetsRegister searchLibraryCatalogue(AssetsRegister availableAssets){
        AssetsRegister filteredAssets = filterAssets(availableAssets);
        System.out.println(filteredAssets);
        return filteredAssets;
    }

    static HashMap<Integer, Person> searchAuthors(HashMap<Integer,Person> allAuthors){
        HashMap<Integer,Person> filteredAuthors = filterAuthors((allAuthors));
        System.out.println(filteredAuthors);
        return filteredAuthors;
    }
    private static HashMap<Integer, Person> filterAuthors(HashMap<Integer,Person> allAuthors){
        var filteredAuthors = new HashMap<Integer,Person>();
        String prompt = "Enter your search term -- asterisk * can be used as a wildcard: ";
        String responsePattern = "^[\\p{L} \\*\\.,'-]+$";
        String query = StandardInput.getValidString(prompt, responsePattern);
        for (Map.Entry<Integer,Person> userEntry:allAuthors.entrySet()){
            Person author = userEntry.getValue();
            if (Search.matchQuery(author,query)){
                filteredAuthors.put(userEntry.getKey(),author);
            }
        }
        if (filteredAuthors.isEmpty()){
            System.out.println("This search did not return any results.");
            return filterAuthors(allAuthors);
        }
        return filteredAuthors;
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
            return filterLibraryUsers(allUsers);
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
        Asset selectedAsset = null;

        while (selectedAsset == null) {
            AssetsRegister filteredAssets = filterAssets(availableAssets);
            selectedAsset = chooseAsset(filteredAssets);
        }

        for (Map.Entry<Integer, Asset> assetEntry : availableAssets.entrySet()) {
            if (assetEntry.getValue().equals(selectedAsset))
                return new AssetRegisterEntry(assetEntry.getKey(), assetEntry.getValue());
        }

        return null;
    }

    private static AssetsRegister filterAssets(AssetsRegister assets) {
        var filteredAssets = new AssetsRegister();

        String prompt = "Enter your search term -- asterisk * can be used as a wildcard: ";
        String responsePattern = "^[\\p{L} \\*\\.,'-]+$";
        String query = StandardInput.getValidString(prompt, responsePattern);

        for (Map.Entry<Integer, Asset> assetEntry : assets.entrySet()) {
            Asset asset = assetEntry.getValue();
            if (Search.matchQuery(asset, query))
                filteredAssets.put(assetEntry.getKey(), asset);
        }

        if (filteredAssets.isEmpty()) {
            System.out.println("This search did not return any results.");
            return filterAssets(assets);
        }

        return filteredAssets;
    }

    private static Asset chooseAsset(AssetsRegister assets) {
        String prompt = "Enter the required asset ID, or 0 to do another search: ";

        System.out.println(assets);
        int assetID = StandardInput.getIntInRange(prompt, 0, assets.getLastID());

        if (assetID == 0)
            return null;

        Asset selectedAsset = assets.getAsset(assetID);
        if (selectedAsset == null) {
            System.out.println(RED + "No asset with that ID exists!" + RESET);
            return chooseAsset(assets);
        }

        return selectedAsset;
    }

}
