package LibrarySystem.library;

import LibrarySystem.library.catalogue.Asset;
import LibrarySystem.library.catalogue.Author;

import java.util.List;

public interface Library {
    int getAssetCount();

    String summariseAllAssets();

    void addAsset(Asset toAdd);

    void addAuthor(Author toAdd);

    void loadSampleData();

    void addUser(LibraryUser libraryUser);
}
