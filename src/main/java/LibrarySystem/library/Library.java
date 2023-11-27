package LibrarySystem.library;

import LibrarySystem.library.catalogue.Asset;
import LibrarySystem.library.catalogue.Author;

public interface Library {
    int getAssetCount();

    String summariseAllAssets();
    String summariseAllUsers();
    int getLastUserID();
    LibraryUser getLibraryUser(int id);

    void addAsset(Asset toAdd);

    void addAuthor(Author toAdd);

    void loadSampleData();

    void addUser(LibraryUser libraryUser);
    Asset getAsset(int Id);
    LibraryUser findUserByKey(int key);

    int getLastAssetID();
}
