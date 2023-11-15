package LibrarySystem.library;

import LibrarySystem.library.catalogue.Asset;

public interface Library {
    void addAsset(Asset toAdd);


    int getAssetCount();

}
