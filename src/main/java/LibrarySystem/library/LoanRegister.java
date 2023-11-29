package LibrarySystem.library;

import LibrarySystem.library.catalogue.Asset;
import LibrarySystem.util.format.StringFormat;

import java.util.ArrayList;

public class LoanRegister extends ArrayList<Loan> {
    public String getAssetsForUser(LibraryUser user) {
        // Select all loans where
        // 1. loan.isActive()
        // 2. loan.getUser().equals(user)
        var selectedAssets = new ArrayList<Asset>();

        for (Loan loan : this) {
            if (loan.isActive() && loan.getUser().equals(user)) {
                selectedAssets.add(loan.getAsset());
            }
        }

        // Format the list of assets and return

        return buildAssetSummary(selectedAssets);
    }

    private String buildAssetSummary(ArrayList<Asset> assetsToSummarise) {
        var assetsSummary = new StringBuilder();

        assetsSummary.append(StringFormat.fixedLength("TYPE", 24));
        assetsSummary.append(StringFormat.fixedLength("TITLE", 36));
        assetsSummary.append(StringFormat.fixedLength("CREATOR", 36));
        assetsSummary.append("\n");

        for (Asset asset : assetsToSummarise) {
            assetsSummary.append(StringFormat.fixedLength(asset.getAssetType(), 24));
            assetsSummary.append(StringFormat.fixedLength(asset.getTitle(), 36));
            assetsSummary.append(StringFormat.fixedLength(asset.getCreatorName(), 36));
            assetsSummary.append("\n");
        }

        return assetsSummary.toString();
    }

}
