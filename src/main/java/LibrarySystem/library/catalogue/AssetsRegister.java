package LibrarySystem.library.catalogue;

import LibrarySystem.util.format.StringFormat;

import java.util.HashMap;

public class AssetsRegister extends HashMap<Integer, Asset> {
    public String toString() {
        var assetsSummary = new StringBuilder();

        assetsSummary.append(StringFormat.fixedLength("ID", 12));
        assetsSummary.append(StringFormat.fixedLength("TYPE", 24));
        assetsSummary.append(StringFormat.fixedLength("TITLE", 36));
        assetsSummary.append(StringFormat.fixedLength("CREATOR", 36));
        assetsSummary.append(StringFormat.fixedLength("QTY", 12));
        assetsSummary.append("\n");

        for (int assetID : this.keySet()) {
            Asset asset = this.get(assetID);
            assetsSummary.append(StringFormat.fixedLength(assetID, 12));
            assetsSummary.append(StringFormat.fixedLength(asset.getAssetType(), 24));
            assetsSummary.append(StringFormat.fixedLength(asset.getTitle(), 36));
            assetsSummary.append(StringFormat.fixedLength(asset.getCreatorName(), 36));
            assetsSummary.append(StringFormat.fixedLength(asset.getQuantity(), 12));
            assetsSummary.append("\n");
        }

        return assetsSummary.toString();
    }
}