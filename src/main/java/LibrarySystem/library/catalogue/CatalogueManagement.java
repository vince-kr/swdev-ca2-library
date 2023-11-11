package LibrarySystem.library.catalogue;

import java.util.ArrayList;

class CatalogueManagement implements Catalogue {
    ArrayList<Author> allAuthors;

    public CatalogueManagement(String csvCatalogueData) {
        this.allAuthors = new ArrayList<>();
    }

    @Override
    public void addAsset(Asset toAdd) {

    }

    @Override
    public void addAuthor(String name) {
        allAuthors.add(new Author(1, name));
    }

    @Override
    public Asset reserveAsset(Asset toReserve) {
        return null;
    }

    @Override
    public Asset borrowAsset(Asset toBorrow) {
        return null;
    }

    @Override
    public void returnAsset(Asset toReturn) {

    }
}
