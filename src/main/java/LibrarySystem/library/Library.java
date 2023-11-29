package LibrarySystem.library;

import LibrarySystem.library.catalogue.Asset;
import LibrarySystem.library.catalogue.Author;
import LibrarySystem.library.catalogue.BookAudioBook;

import java.util.HashMap;
import java.util.List;

public interface Library {
    // Users
    LibraryUser getUser(int id);

    void addUser(LibraryUser libraryUser);

    int getLastUserID();

    String summariseAllUsers();

    HashMap<Integer, LibraryUser> getAllUsers();
    // Assets
    Asset getAsset(int Id);

    void addAsset(Asset toAdd);

    int getAssetCount();

    int getLastAssetID();

    String summariseAllAssets();

    String summariseBorrowedAssets();


    // Other catalogue operations
    HashMap<Integer, Author> getAllAuthors();
    HashMap<Integer,Asset> getAllAssets();

    Author addAuthor(String name) throws PersonException;

    void loadSampleData();
}
