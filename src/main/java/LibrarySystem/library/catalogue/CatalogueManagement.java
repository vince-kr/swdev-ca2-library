package LibrarySystem.library.catalogue;

import LibrarySystem.util.format.StringFormat;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class CatalogueManagement implements Catalogue {

    final HashMap<Integer, Author> allAuthors;
    final HashMap<Integer, Asset> allAssets;

    public CatalogueManagement(String csvCatalogueData) {
        allAuthors = new HashMap<>();
        allAssets = new HashMap<>();
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
    public String summariseAllAssets() {
        var assetsSummary = new StringBuilder();
        assetsSummary.append(StringFormat.fixedLength("ID", 12));
        assetsSummary.append(StringFormat.fixedLength("TITLE", 36));
        assetsSummary.append(StringFormat.fixedLength("CREATOR", 36));
        assetsSummary.append("\n");

        for (int assetID : this.allAssets.keySet()) {
            Asset asset = allAssets.get(assetID);
            assetsSummary.append(StringFormat.fixedLength(assetID, 12));
            assetsSummary.append(StringFormat.fixedLength(asset.getTitle(), 36));
            assetsSummary.append(StringFormat.fixedLength(asset.getCreatorName(), 36));
            assetsSummary.append("\n");
        }


        return assetsSummary.toString();
    }

    @Override
    public void addAuthor(Author toAdd) {
        int nextID = computeCurrentID(allAuthors.keySet());
        allAuthors.put(nextID, toAdd);
    }

    @Override
    public Asset getAsset(int Id) {
        return allAssets.get(Id);
    }

    private int computeCurrentID(Collection<Integer> keys) {
        return keys.isEmpty() ? 10000 : Collections.max(keys);
    }

}
