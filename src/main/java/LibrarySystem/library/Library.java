package LibrarySystem.library;

import LibrarySystem.library.catalogue.Asset;

import java.util.List;

public interface Library {
    void addAsset(Asset toAdd);

    int getAssetCount();

    String summariseAllAssets();
}
