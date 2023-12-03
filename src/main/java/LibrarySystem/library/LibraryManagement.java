package LibrarySystem.library;

import LibrarySystem.library.catalogue.*;

import java.util.HashMap;
import java.util.Map;

class LibraryManagement implements Library {

    final Catalogue catalogue;
    final LibraryUserRegister allUsers;
    final LoanRegister allLoans;

/*
     The constructor of the LibraryManagement class creates a Catalogue object (really a
     CatalogueManagement object that implements the Catalogue interface) by calling the
     CatalogueFactory.createCatalogue method. It passes in CSV data that represents the Catalogue's
     assets. For now this is fake data.
*/

    public LibraryManagement() {
        catalogue = CatalogueFactory.createCatalogue("some,mock,csv,data");
        allUsers = new LibraryUserRegister();
        allLoans = new LoanRegister();
    }

    @Override
    public LibraryUser getUser(int id) {
        return allUsers.get(id);
    }

    @Override
    public void addUser(LibraryUser newUser) {
        allUsers.addUser(newUser);
    }

    @Override
    public LibraryUserRegister getAllUsers() {
        return allUsers;
    }

    @Override
    public boolean hasUsers() {
        return !allUsers.isEmpty();
    }

    @Override
    public Asset getAsset(int id) {
        return catalogue.getAsset(id);
    }

    public AssetsRegister getAllAssets() {
        return catalogue.getAllAssets();
    }

    @Override
    public AssetsRegister getAvailableAssets() {
        var availableAssets = new AssetsRegister();

        for (Map.Entry<Integer, Asset> assetEntry : getAllAssets().entrySet()) {
            Asset asset = assetEntry.getValue();

            if (asset.getQuantity() > allLoans.countActiveLoans(asset))
                availableAssets.put(assetEntry.getKey(), asset);
        }

        return availableAssets;
    }

    @Override
    public AssetsRegister getBorrowedAssets() {
        var borrowedAssets = new AssetsRegister();
        for (Loan loan : allLoans) {
            if (loan.isActive())
                borrowedAssets.put(loan.getAssetID(), loan.getAsset());
        }

        return borrowedAssets;
    }

    @Override
    public AssetsRegister getOverDueLoans() {
        var overDueLoans = new AssetsRegister();
        for (Loan loan:allLoans){
            if (loan.isActive() && loan.loanOverdue()){
              overDueLoans.put(loan.getAssetID(), loan.getAsset());
            }
        }
        return overDueLoans;
    }

    @Override
    public int getLoansOneAsset(Asset asset) {
        int count = 0;
        for (Loan loan : allLoans) {
            if (loan.getAsset().equals(asset))
                count++;
        }
        return count;
    }

    @Override
    public void addAsset(Asset toAdd) {
        catalogue.addAsset(toAdd);
    }

    @Override
    public int getAssetCount() {
        return catalogue.getAssetCount();
    }

    @Override
    public AssetsRegister getAssetsForUser(LibraryUser user) {
        return allLoans.getLoansForUser(user);
    }

    @Override
    public AssetsRegister getAssetsForCreator(Person creator) {
        return catalogue.getAssetsForCreator(creator);
    }

    @Override
    public HashMap<Integer, Person> getAllCreators() {
        return catalogue.getAllCreators();
    }

    @Override
    public int getLastCreatorID() {
        return catalogue.getLastCreatorID();
    }

    @Override
    public Author addAuthor(String name) throws PersonException {
        return catalogue.addAuthor(name);
    }

    @Override
    public Producer addProducer(String name) throws PersonException {
        return catalogue.addProducer(name);
    }

    @Override
    public Director addDirector(String name) throws PersonException {
        return catalogue.addDirector(name);
    }

    @Override
    public void loadSampleData() {
        try {
            Author sampleAuthor = new Author("Terry Pratchett");
            Producer sampleProducer = new Producer("Scott Litt");
            Director sampleDirector = new Director("R.E.M.");

            Asset dw1 = new BookAudioBook("The Colour of Magic", 2, "0-86140-324-X", "1983", sampleAuthor);
            Asset dw2 = new BookAudioBook("The Light Fantastic", 1, "0-86140-203-0", "1986", sampleAuthor);
            Asset dw3 = new BookAudioBook("Equal Rites", 5, "0-575-03950-7", "1987", sampleAuthor);
            Asset dw4 = new CdDvd("Out of time", 12, sampleProducer, sampleDirector, 44*60+8, "1991");

            this.addAuthor("Terry Pratchett");
            this.addDirector("R.E.M.");
            this.addAsset(dw1);
            this.addAsset(dw2);
            this.addAsset(dw3);
            this.addAsset(dw4);
        } catch (PersonException pe) {}
    }

    @Override
    public LoanRegister getAllLoans() {
        return allLoans;
    }

    @Override
    public void recordLoan(Loan newLoan) {
        allLoans.add(newLoan);
    }

    @Override
    public Loan getLoan(Asset asset) {
        for (Loan loan : allLoans) {
            if (loan.getAsset().equals(asset))
                return loan;
        }
        return null;
    }
}
