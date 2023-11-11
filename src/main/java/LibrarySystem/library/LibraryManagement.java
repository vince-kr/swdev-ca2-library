package LibrarySystem.library;

import LibrarySystem.library.catalogue.Asset;
import LibrarySystem.library.catalogue.Author;
import LibrarySystem.library.catalogue.Catalogue;
import LibrarySystem.library.catalogue.CatalogueFactory;

import java.util.ArrayList;

class LibraryManagement implements Library, Catalogue {
    final Catalogue catalogue;
    // The constructor of the LibraryManagement class creates a Catalogue object (really a
    // CatalogueManagement object that implements the Catalogue interface) by calling the
    // CatalogueFactory.createCatalogue method. It passes in CSV data that represents the Catalogue's
    // assets, authors, etc. For now this is fake data, we will learn how to read from disk in our
    // next lecture.

    final ArrayList<Author> allAuthors;

    public LibraryManagement() {
        catalogue = CatalogueFactory.createCatalogue("some,mock,csv,data");
        allAuthors = new ArrayList<>();
    }

    // Library methods
    @Override
    public void addUser() {

    }

    @Override
    public void addAuthor(String name) {
        allAuthors.add(new Author(allAuthors.size(), name));
    }

    // Catalogue methods - their equivalents are called on the Catalogue object
    @Override
    public void addAsset(Asset toAdd) {
        catalogue.addAsset(toAdd);
    }

    @Override
    public Asset reserveAsset(Asset toReserve) {
        return catalogue.reserveAsset(toReserve);
    }

    @Override
    public Asset borrowAsset(Asset toBorrow) {
        return catalogue.borrowAsset(toBorrow);
    }

    @Override
    public void returnAsset(Asset toReturn) {
        catalogue.returnAsset(toReturn);
    }
}
