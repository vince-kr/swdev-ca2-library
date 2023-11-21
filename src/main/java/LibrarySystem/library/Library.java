package LibrarySystem.library;

import LibrarySystem.library.catalogue.Asset;
import LibrarySystem.library.catalogue.Author;

import java.util.List;

public interface Library {
    int getAssetCount();

    String summariseAllAssets();
    String summariseAllUsers();
    void addAsset(Asset toAdd);

    void addAuthor(Author toAdd);

    void loadSampleData();

    void addUser(LibraryUser libraryUser);
    Asset borrowAsset(int Id);
    LibraryUser findUserByKey(int key);
}
