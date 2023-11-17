package LibrarySystem.library.catalogue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

class CatalogueManagement implements Catalogue {

    final ArrayList<Author> allAuthors;
    final HashMap<Integer, Asset> allAssets;

    public CatalogueManagement(String csvCatalogueData) {
        allAuthors = new ArrayList<>();
        allAssets = new HashMap<>();
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

    @Override
    public String summariseAllAssets() {
        var assetsSummary = new StringBuilder();
        for (int assetID : this.allAssets.keySet())
            assetsSummary.append(assetID + "\t" + allAssets.get(assetID));

        return assetsSummary.toString();
    }

    /*
         return an asset
         from allAssets hash map
         */
    public Asset findAssetByKey(int key){
                return allAssets.get(key);
    }
}
