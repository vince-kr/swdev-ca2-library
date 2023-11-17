package LibrarySystem.library.catalogue;

public interface Catalogue {
    int getAssetCount();
    String summariseAllAssets();
    void addAsset(Asset toAdd);
    void addAuthor(Author toAdd);
}
