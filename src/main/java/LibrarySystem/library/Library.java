package LibrarySystem.library;

import LibrarySystem.library.catalogue.*;

import java.util.HashMap;

public interface Library {
    // Users
    LibraryUser getUser(int id);

    void addUser(LibraryUser libraryUser);

    int getLastUserID();

    LibraryUserRegister getAllUsers();

    // Assets
    AssetsRegister getAllAssets();

    Asset getAsset(int id);

    void addAsset(Asset toAdd);

    int getAssetCount();

    int getLastAssetID();

    AssetsRegister getBorrowedAssets();

    int getLoansOneAsset(Asset asset);

    AssetsRegister getAssetsForUser(LibraryUser user);

    // Loan operations
    LoanRegister getAllLoans();

    void recordLoan(Loan newLoan);

    // Other catalogue operations
    HashMap<Integer, Person> getAllCreators();

    int getLastCreatorID();

    Author addAuthor(String name) throws PersonException;
    Producer addProducer(String name) throws PersonException;
    Director addDirector(String name) throws PersonException;

    void loadSampleData();

    AssetsRegister getAssetsForCreator(Person creator);
}
