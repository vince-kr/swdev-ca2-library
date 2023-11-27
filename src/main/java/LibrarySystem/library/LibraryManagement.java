package LibrarySystem.library;

import LibrarySystem.library.catalogue.*;

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
    public int getLastAssetID() {
        return catalogue.getLastID();
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
    public LibraryUser getLibraryUser(int id) {
        return allUsers.get(id);
    }

    @Override
    public void addUser(LibraryUser newUser) {
        allUsers.addUser(newUser);
    }

    @Override
    public String summariseAllUsers() {
        return allUsers.summariseUsers();
    }

    @Override
    public int getLastUserID() {
        return allUsers.getLastID();
    }

    @Override
    public Asset getAsset(int Id) {
        return catalogue.getAsset(Id);
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
            Author sampleAuthor = new Author("TP");
            Asset dw1 = new BookAudioBook("The Colour of Magic", "0-86140-324-X", "1983", sampleAuthor);
            Asset dw2 = new BookAudioBook("The Light Fantastic", "0-86140-203-0", "1986", sampleAuthor);
            Asset dw3 = new BookAudioBook("Equal Rites", "0-575-03950-7", "1987", sampleAuthor);

            this.addAuthor(sampleAuthor);
            this.addAsset(dw1);
            this.addAsset(dw2);
            this.addAsset(dw3);
        } catch (PersonException pe) {}
    }

    @Override
    public LibraryUser findUserByKey(int key){
        return allUsers.get(key);
    }

}
