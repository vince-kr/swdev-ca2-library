package LibrarySystem.library;

import LibrarySystem.library.catalogue.Asset;
import LibrarySystem.library.catalogue.AssetsRegister;

import java.util.ArrayList;

public class LoanRegister extends ArrayList<Loan> {
    public AssetsRegister getAssetsForUser(LibraryUser user) {
        // Select all loans where
        // 1. loan.isActive()
        // 2. loan.getUser().equals(user)
        var selectedAssets = new AssetsRegister();

        for (Loan loan : this) {
            if (loan.isActive() && loan.getUser().equals(user)) {
                selectedAssets.put(loan.getID(), loan.getAsset());
            }
        }

        // Format the list of assets and return
        return selectedAssets;
    }

    public int countActiveLoans(Asset asset) {
        int count = 0;

        for (Loan loan : this) {
            if (loan.getAsset().equals(asset))
                count++;
        }

        return count;
    }
}
