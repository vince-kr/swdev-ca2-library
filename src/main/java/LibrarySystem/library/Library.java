package LibrarySystem.library;

import LibrarySystem.library.catalogue.Asset;
import LibrarySystem.library.catalogue.Author;

import java.util.HashMap;

public interface Library {
    // Users
    LibraryUser getUser(int id);

    void addUser(LibraryUser libraryUser);

    int getLastUserID();

    String summariseAllUsers();

    HashMap<Integer, LibraryUser> getAllUsers();

    // Assets
    Asset getAsset(int id);

    void addAsset(Asset toAdd);

    int getAssetCount();

    int getLastAssetID();

    String summariseAllAssets();

    String summariseBorrowedAssets();

    String getAssetsForUser(LibraryUser user);

    // Loan operations
    LoanRegister getAllLoans();

    void recordLoan(Loan newLoan);

    // Other catalogue operations
    HashMap<Integer, Author> getAllAuthors();

    HashMap<Integer,Asset> getAllAssets();

    Author addAuthor(String name) throws PersonException;

    void loadSampleData();
}
