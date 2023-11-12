package LibrarySystem.library;

import LibrarySystem.library.catalogue.Asset;
import LibrarySystem.library.catalogue.Catalogue;
import LibrarySystem.library.catalogue.CatalogueFactory;
import LibrarySystem.util.format.*;

import java.util.ArrayList;

class LibraryManagement implements Library, Catalogue {

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
        allUsers = new ArrayList<>();
        catalogue = CatalogueFactory.createCatalogue("some,mock,csv,data");
    }

    public int getCustomerCount() {
        return allUsers.size();
    }

    // Library methods
    @Override
    public void addUser(String name) {
        int nextID = getCustomerCount() + 1;
        allUsers.add(new LibraryUser(nextID, name));
    }

    @Override
    public String getAllUsers() {
        var ur = new StringBuilder();
        String header = StringFormat.fixedLength("ID", 8) + "NAME\n";
        ur.append(header);

        for (LibraryUser u : allUsers) {
            String id = StringFormat.fixedLength(u.getId(), 8);
            String name = u.getName();
            ur.append(id + name);
        }

        return ur.toString();
    }

    // Catalogue methods - their equivalents are called on the Catalogue object
    @Override
    public void addAuthor(String name) {
        catalogue.addAuthor(name);
    }

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
