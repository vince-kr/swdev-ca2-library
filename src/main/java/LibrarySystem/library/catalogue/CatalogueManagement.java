package LibrarySystem.library.catalogue;

import LibrarySystem.library.PersonException;
import LibrarySystem.util.format.StringFormat;

import java.util.*;

class CatalogueManagement implements Catalogue {

    final HashMap<Integer, Author> allAuthors;
    final AssetsRegister allAssets;

    public CatalogueManagement(String csvCatalogueData) {
        allAuthors = new HashMap<>();
        allAssets = new AssetsRegister();
    }

    @Override
    public void addAsset(Asset toAdd) {
        int currentID = computeCurrentID(allAssets.keySet());
        allAssets.put(currentID + 1, toAdd);
    }

    @Override
    public int getAssetCount() {
        return allAssets.size();
    }

    @Override
    public int getLastID() {
        return computeCurrentID(allAssets.keySet());
    }

    @Override
    public HashMap<Integer, Author> getAllAuthors() {
        return allAuthors;
    }

    public AssetsRegister getAllAssets() {
        return allAssets;
    }


    @Override
    public Author addAuthor(String name) throws PersonException {
        for (Author existingAuthor : allAuthors.values()) {
            String authorName = existingAuthor.getName();
            if (authorName.equals(name))
                // Existing author found
                return existingAuthor;
        }

        // If this is reached, no existing author was found
        int currentID = computeCurrentID(allAuthors.keySet());
        var newAuthor = new Author(name);
        allAuthors.put(currentID + 1, newAuthor);

        return newAuthor;
    }

    @Override
    public Asset getAsset(int Id) {
        return allAssets.get(Id);
    }

    private int computeCurrentID(Collection<Integer> keys) {
        return keys.isEmpty() ? 10000 : Collections.max(keys);
    }

}
