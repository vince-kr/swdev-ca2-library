package LibrarySystem.library.catalogue;

import LibrarySystem.library.PersonException;
import LibrarySystem.util.format.StringFormat;

import java.net.Inet4Address;
import java.util.*;
import java.util.stream.Collectors;

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
        return buildAssetSummary(this.allAssets);
    }

    @Override
    public String summariseBorrowedAssets() {
        var borrowedAssets = new HashMap<Integer, Asset>();

        for (Map.Entry<Integer, Asset> assetEntry : this.allAssets.entrySet()) {
            if (!assetEntry.getValue().getAvailability())
                borrowedAssets.put(assetEntry.getKey(), assetEntry.getValue());
        }

        return buildAssetSummary(borrowedAssets);
    }

    private String buildAssetSummary(HashMap<Integer, Asset> assetsToSummarise) {
        var assetsSummary = new StringBuilder();

        assetsSummary.append(StringFormat.fixedLength("ID", 12));
        assetsSummary.append(StringFormat.fixedLength("TYPE", 24));
        assetsSummary.append(StringFormat.fixedLength("TITLE", 36));
        assetsSummary.append(StringFormat.fixedLength("CREATOR", 36));
        assetsSummary.append("\n");

        for (int assetID : assetsToSummarise.keySet()) {
            Asset asset = allAssets.get(assetID);
            assetsSummary.append(StringFormat.fixedLength(assetID, 12));
            assetsSummary.append(StringFormat.fixedLength(asset.getAssetType(), 24));
            assetsSummary.append(StringFormat.fixedLength(asset.getTitle(), 36));
            assetsSummary.append(StringFormat.fixedLength(asset.getCreatorName(), 36));
            assetsSummary.append("\n");
        }

        return assetsSummary.toString();
    }

    @Override
    public HashMap<Integer, Author> getAllAuthors() {
        return allAuthors;
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
