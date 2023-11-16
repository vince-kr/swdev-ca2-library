package LibrarySystem.library.catalogue;

import LibrarySystem.library.PersonException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

class CatalogueManagement implements Catalogue {

    final ArrayList<Author> allAuthors;
    final HashMap<Integer, Asset> allAssets;

    public CatalogueManagement(String csvCatalogueData) throws PersonException {
        allAuthors = new ArrayList<>();
        allAssets = new HashMap<>();

        allAssets.put(10000000, new BookAudioBook("placeholder", "0-86140-324-X", "1983", new Author(2, "Terry Pratchett"),1));
    }

    @Override
    public void addAsset(Asset toAdd) {
        int nextID = computeNextAssetID();
        allAssets.put(nextID, toAdd);
    }

    private int computeNextAssetID() {
        int currentLargestKey = allAssets.isEmpty() ? 10000000 : Collections.max(allAssets.keySet());
        return currentLargestKey + 1;
    }

    @Override
    public int getAssetCount() {
        return allAssets.size();
    }
    /*
     return an asset
     from allAssets hash map
     */
    public Asset findAssetByKey(int key){
                return allAssets.get(key);
    }
}
