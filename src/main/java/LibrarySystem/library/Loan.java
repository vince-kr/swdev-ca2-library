package LibrarySystem.library;

import LibrarySystem.library.catalogue.Asset;

import java.time.LocalDate;

public class Loan {
    Asset toBorrow;
    LibraryUser doingBorrowing;
    LocalDate dateIssued;
    LocalDate dateDue;
    boolean isActive;

    public Loan(LibraryUser doingBorrowing, Asset toBorrow) {
        this.doingBorrowing = doingBorrowing;
        this.toBorrow = toBorrow;
        this.dateIssued = LocalDate.now();
        this.dateDue = dateIssued.plusDays(21);
        this.isActive = true;
    }

    Asset getAsset() {
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
