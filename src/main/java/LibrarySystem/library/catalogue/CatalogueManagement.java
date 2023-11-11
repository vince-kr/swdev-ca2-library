package LibrarySystem.library.catalogue;

import java.util.ArrayList;

class CatalogueManagement implements Catalogue {

    final ArrayList<Author> allAuthors;

    public CatalogueManagement(String csvCatalogueData) {
        allAuthors = new ArrayList<>();
    }

    @Override
    public void addAuthor(String name) {
        allAuthors.add(new Author(allAuthors.size(), name));
    }

    @Override
    public void addAsset(Asset toAdd) {

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
