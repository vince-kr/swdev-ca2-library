package LibrarySystem.library.catalogue;

import java.net.Inet4Address;
import java.util.HashMap;
import java.util.List;

public interface Catalogue {
    int getAssetCount();
    String summariseAllAssets();
    void addAsset(Asset toAdd);
    void addAuthor(Author toAdd);
    Asset getAsset(int Id);

    int getLastID();

    String summariseBorrowedAssets();

    HashMap<Integer, Author> getAllAuthors();
}
