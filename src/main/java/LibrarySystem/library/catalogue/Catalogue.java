package LibrarySystem.library.catalogue;

import LibrarySystem.library.PersonException;

import java.util.HashMap;

public interface Catalogue {
    int getAssetCount();
    void addAsset(Asset toAdd);
    Author addAuthor(String name) throws PersonException;
    Asset getAsset(int Id);

    int getLastID();

    HashMap<Integer, Author> getAllAuthors();
    AssetsRegister getAllAssets();

}
