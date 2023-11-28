package LibrarySystem.library;

import LibrarySystem.library.catalogue.Asset;
import LibrarySystem.library.catalogue.Author;

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
    void addAuthor(String name);

    void loadSampleData();
}
