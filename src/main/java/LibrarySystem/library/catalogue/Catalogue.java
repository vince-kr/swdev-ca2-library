package LibrarySystem.library.catalogue;

import LibrarySystem.library.PersonException;

import java.net.Inet4Address;
import java.util.HashMap;
import java.util.List;

public interface Catalogue {
    int getAssetCount();
    String summariseAllAssets();
    void addAsset(Asset toAdd);
    Author addAuthor(String name) throws PersonException;
    Asset getAsset(int Id);

    int getLastID();

    String summariseBorrowedAssets();

    HashMap<Integer, Author> getAllAuthors();
    HashMap<Integer,Asset> getAllAssets();
}
