package LibrarySystem.library.catalogue;

import java.util.ArrayList;

class CatalogueManagement implements Catalogue {

    final ArrayList<Author> allAuthors;
    final ArrayList<Asset> allAssets;

    public CatalogueManagement(String csvCatalogueData) {
        allAuthors = new ArrayList<>();
        allAssets = new ArrayList<>();
    }

    @Override
    public void addAsset(Asset toAdd) {
        allAssets.add(toAdd);
    }
}
