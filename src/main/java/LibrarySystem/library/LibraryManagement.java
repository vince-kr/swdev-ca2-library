package LibrarySystem.library;

import LibrarySystem.library.catalogue.*;

import java.util.HashMap;
import java.util.List;

class LibraryManagement implements Library {

    final Catalogue catalogue;
    final LibraryUserRegistry allUsers;

/*
     The constructor of the LibraryManagement class creates a Catalogue object (really a
     CatalogueManagement object that implements the Catalogue interface) by calling the
     CatalogueFactory.createCatalogue method. It passes in CSV data that represents the Catalogue's
     assets, authors, etc. For now this is fake data, we will learn how to read from disk in our
     next lecture.
*/

    public LibraryManagement() {
        catalogue = CatalogueFactory.createCatalogue("some,mock,csv,data");
        allUsers = new LibraryUserRegistry();
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
    public int getLastUserID() {
        return allUsers.getLastID();
    }

    @Override
    public String summariseAllUsers() {
        return allUsers.summariseUsers();
    }

    @Override
    public Asset getAsset(int id) {
        return catalogue.getAsset(id);
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
    public int getLastAssetID() {
        return catalogue.getLastID();
    }

    @Override
    public String summariseAllAssets() {
        return catalogue.summariseAllAssets();
    }

    @Override
    public String summariseBorrowedAssets() {
        return catalogue.summariseBorrowedAssets();
    }

    @Override
    public HashMap<Integer, Author> getAllAuthors() {
        return catalogue.getAllAuthors();
    }

    @Override
    public HashMap<Integer, Asset> getAllAssets() {
        return catalogue.getAllAssets();
    }

    @Override
    public void addAuthor(String name) {
        try {
            catalogue.addAuthor(new Author(name));
        } catch (PersonException pe) {}
    }

    @Override
    public void loadSampleData() {
        try {
            Author sampleAuthor = new Author("Terry Pratchett");
            Producer sampleProducer = new Producer("Scott Litt");
            Director sampleDirector = new Director("Ridley Scott");

            Asset dw1 = new BookAudioBook("The Colour of Magic", "0-86140-324-X", "1983", sampleAuthor);
            Asset dw2 = new BookAudioBook("The Light Fantastic", "0-86140-203-0", "1986", sampleAuthor);
            Asset dw3 = new BookAudioBook("Equal Rites", "0-575-03950-7", "1987", sampleAuthor);
            Asset dw4 = new CdDvd("Out of time", sampleProducer, sampleDirector, 44*60+8, "1991");

            this.addAuthor("Terry Pratchett");
            this.addAsset(dw1);
            this.addAsset(dw2);
            this.addAsset(dw3);
            this.addAsset(dw4);
        } catch (PersonException pe) {}
    }
}
