package LibrarySystem.library;

import LibrarySystem.library.catalogue.Asset;
import LibrarySystem.library.catalogue.Catalogue;
import LibrarySystem.library.catalogue.CatalogueFactory;

import java.util.ArrayList;

class LibraryManagement implements Library {

    ArrayList<LibraryUser> allUsers;
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
    }

    @Override
    public void addAsset(Asset toAdd) {
        catalogue.addAsset(toAdd);
    }

    @Override
    public int getAssetCount() {
        return catalogue.getAssetCount();
    }

}
