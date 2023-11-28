package LibrarySystem.library;

import LibrarySystem.library.catalogue.Asset;
import LibrarySystem.library.catalogue.Author;

import java.util.HashMap;
import java.util.List;

public interface Library {
    // Users
    LibraryUser getUser(int id);

    void addUser(LibraryUser libraryUser);

    int getLastUserID();

    String summariseAllUsers();


    // Assets
    Asset getAsset(int Id);

    void addAsset(Asset toAdd);

    int getAssetCount();

    int getLastAssetID();

    String summariseAllAssets();

    String summariseBorrowedAssets();


    // Other catalogue operations
    HashMap<Integer, Author> getAllAuthors();

    void addAuthor(String name);

    void loadSampleData();
}
