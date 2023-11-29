package LibrarySystem.library.catalogue;

import java.util.Map.Entry;

public class AssetRegisterEntry implements Entry<Integer, Asset> {
    int id;
    Asset asset;

    public AssetRegisterEntry(int key, Asset asset) {
        this.id = key;
        this.asset = asset;
    }

    @Override
    public Integer getKey() {
        return id;
    }

    @Override
    public Asset getValue() {
        return asset;
    }

    @Override
    public Asset setValue(Asset asset) {
        this.asset = asset;
        return asset;
    }
}
