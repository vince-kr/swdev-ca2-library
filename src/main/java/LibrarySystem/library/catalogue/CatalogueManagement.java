package LibrarySystem.library.catalogue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

class CatalogueManagement implements Catalogue {

    final ArrayList<Author> allAuthors;
    final HashMap<Integer, Asset> allAssets;

    public CatalogueManagement(String csvCatalogueData) {
        allAuthors = new ArrayList<>();
        allAssets = new HashMap<>();
        allAssets.put(10000000, new BookAudioBook("placeholder", "0-86140-324-X", "1983", new Author(2, "Terry Pratchett")));
    }

    @Override
    public void addAsset(Asset toAdd) {
        int nextID = computeNextAssetID();
        allAssets.put(nextID, toAdd);
    }

    private int computeNextAssetID() {
        int currentLargestKey = Collections.max(allAssets.keySet());
        return currentLargestKey + 1;
    }
}
