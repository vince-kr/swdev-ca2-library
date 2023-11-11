package LibrarySystem.library.catalogue;

public interface Catalogue {
    void addAsset(Asset toAdd);
    Asset reserveAsset(Asset toReserve);
    Asset borrowAsset(Asset toBorrow);
    void returnAsset(Asset toReturn);
}
