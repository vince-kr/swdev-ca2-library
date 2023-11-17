package LibrarySystem.library.catalogue;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

class CatalogueManagement implements Catalogue {

    final HashMap<Integer, Author> allAuthors;
    final HashMap<Integer, Asset> allAssets;

    public CatalogueManagement(String csvCatalogueData) {
        allAuthors = new HashMap<>();
        allAssets = new HashMap<>();
    }

    @Override
    public void addAsset(Asset toAdd) {
        int nextID = computeNextID(allAssets.keySet());
        allAssets.put(nextID, toAdd);
    }

    @Override
    public int getAssetCount() {
        return allAssets.size();
    }

    @Override
    public String summariseAllAssets() {
        var assetsSummary = new StringBuilder();
        for (int assetID : this.allAssets.keySet())
            assetsSummary.append(assetID + "\t" + allAssets.get(assetID) + "\n");

        return assetsSummary.toString();
    }

    @Override
    public void addAuthor(Author toAdd) {
        int nextID = computeNextID(allAuthors.keySet());
        allAuthors.put(nextID, toAdd);
    }

    private int computeNextID(Collection<Integer> keys) {
        int currentLargestKey = keys.isEmpty() ? 10000000 : Collections.max(keys);
        return currentLargestKey + 1;
    }

    /*
             return an asset
             from allAssets hash map
             */
    public Asset findAssetByKey(int key){
                return allAssets.get(key);
    }
}
