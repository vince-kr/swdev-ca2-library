package LibrarySystem.library;

import LibrarySystem.library.catalogue.Asset;

public class Loan {
    Asset toBorrow;
    LibraryUser doingBorrowing;
    boolean isActive;

    public Loan(Asset toBorrow, LibraryUser doingBorrowing) {
        this.toBorrow = toBorrow;
        this.doingBorrowing = doingBorrowing;
        this.isActive = true;
    }

    public void returnAsset() {
        isActive = false;
    }
}
