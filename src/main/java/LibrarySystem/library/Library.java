package LibrarySystem.library;

import LibrarySystem.library.catalogue.Asset;
import LibrarySystem.library.catalogue.AssetsRegister;
import LibrarySystem.library.catalogue.Author;

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

    AssetsRegister getAssetsForUser(LibraryUser user);

    // Loan operations
    LoanRegister getAllLoans();

    void recordLoan(Loan newLoan);

    // Other catalogue operations
    HashMap<Integer, Author> getAllAuthors();

    Author addAuthor(String name) throws PersonException;

    void loadSampleData();
}
