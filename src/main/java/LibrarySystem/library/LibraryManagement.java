package LibrarySystem.library;

import LibrarySystem.library.catalogue.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

class LibraryManagement implements Library {

    HashMap<Integer, LibraryUser> allUsers;
    final Catalogue catalogue;

/*
     The constructor of the LibraryManagement class creates a Catalogue object (really a
     CatalogueManagement object that implements the Catalogue interface) by calling the
     CatalogueFactory.createCatalogue method. It passes in CSV data that represents the Catalogue's
     assets, authors, etc. For now this is fake data, we will learn how to read from disk in our
     next lecture.
*/

    public LibraryManagement() {
        catalogue = CatalogueFactory.createCatalogue("some,mock,csv,data");
        allUsers = new HashMap<>();
    }

    @Override
    public void addAsset(Asset toAdd) {
        catalogue.addAsset(toAdd);
    }

    @Override
    public void addAuthor(Author newAuthor) {
        catalogue.addAuthor(newAuthor);
    }

    @Override
    public void addUser(LibraryUser libraryUser) {
        int nextID = computeNextUserID();
        allUsers.put(nextID, libraryUser);
    }

    private int computeNextUserID() {
        int currentLargestKey = allUsers.isEmpty() ? 10000000 : Collections.max(allUsers.keySet());
        return currentLargestKey + 1;
    }

    @Override
    public int getAssetCount() {
        return catalogue.getAssetCount();
    }

    @Override
    public String summariseAllAssets() {
        return catalogue.summariseAllAssets();
    }

    @Override
    public void loadSampleData() {
        try {
            Author sampleAuthor = new Author(420, "TP");
            Asset dw1 = new BookAudioBook("The Colour of Magic", "0-86140-324-X", "1983", sampleAuthor, 1);
            Asset dw2 = new BookAudioBook("The Light Fantastic", "0-86140-203-0", "1986", sampleAuthor, 1);
            Asset dw3 = new BookAudioBook("Equal Rites", "0-575-03950-7", "1987", sampleAuthor, 1);

            this.addAuthor(sampleAuthor);
            this.addAsset(dw1);
            this.addAsset(dw2);
            this.addAsset(dw3);
        } catch (PersonException pe) {}
    }
}
