package library.catalogue;

public interface Catalogue {
    void addAsset();
    void addAuthor();
    Asset reserveAsset();
    Asset borrowAsset();
    void returnAsset();
}
