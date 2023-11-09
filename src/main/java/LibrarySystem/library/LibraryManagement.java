package library;

import library.catalogue.Catalogue;
import library.catalogue.CatalogueFactory;

class LibraryManagement implements Library {
    Catalogue catalogue;
    // The constructor of the LibraryManagement class creates a Catalogue object (really a
    // CatalogueManagement object that implements the Catalogue interface) by calling the
    // CatalogueFactory.createCatalogue method. It passes in CSV data that represents the Catalogue's
    // assets, authors, etc. For now this is fake data, we will learn how to read from disk in our
    // next lecture.

    public LibraryManagement() {
        catalogue = CatalogueFactory.createCatalogue("some,mock,csv,data");
    };

    @Override
    public void addUser() {

    }
}
