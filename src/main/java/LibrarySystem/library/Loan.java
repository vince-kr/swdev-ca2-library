package LibrarySystem.library;

import LibrarySystem.library.catalogue.Asset;
import LibrarySystem.library.catalogue.AssetRegisterEntry;

import java.time.LocalDate;

public class Loan {
    AssetRegisterEntry toBorrow;
    LibraryUser doingBorrowing;
    LocalDate dateIssued;
    LocalDate dateDue;
    boolean isActive;

    public Loan(LibraryUser doingBorrowing, AssetRegisterEntry toBorrow) {
        this.doingBorrowing = doingBorrowing;
        this.toBorrow = toBorrow;
        this.dateIssued = LocalDate.now();
        this.dateDue = dateIssued.plusDays(21);
        this.isActive = true;
    }

    int getID() {
        return toBorrow.getKey();
    }

    Asset getAsset() {
        return toBorrow.getValue();
    }

    AssetRegisterEntry getEntry() {
        return toBorrow;
    }

    public LibraryUser getUser() {
        return doingBorrowing;
    }

    public boolean isActive() {
        return isActive;
    }

    public void returnAsset() {
        isActive = false;
    }

    public boolean loanOverdue() {
        LocalDate today = LocalDate.now();
        return this.isActive && today.isAfter(dateDue);
    }
}
