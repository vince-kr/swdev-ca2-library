package LibrarySystem.library.catalogue;

import java.util.List;

public interface Catalogue {
    void addAsset(Asset toAdd);

    int getAssetCount();

    String summariseAllAssets();
}
