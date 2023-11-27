package LibrarySystem.interactor;

import LibrarySystem.library.Library;
import LibrarySystem.library.LibraryFactory;
import LibrarySystem.library.LibraryUser;
import LibrarySystem.library.PersonException;
import LibrarySystem.library.catalogue.Asset;
import LibrarySystem.library.catalogue.Author;
import LibrarySystem.library.catalogue.BookAudioBook;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class BorrowAssetTest {
    Library library = LibraryFactory.createLibrary();
    private LibraryUser user;
    private Asset asset;


    ArrayList<Asset> assets = new ArrayList<>();
    HashMap<Integer,Asset> assetHashMaps = new HashMap<>();
    @BeforeEach
    void setUp() throws PersonException {
        user = new LibraryUser("John Doe");
        Author author = new Author("King James");
        asset = new BookAudioBook("Holy Bible","0-987-12377-7","1867",author,1);

    }

    @Test
    void requestAndResponse() {
        //before borrowing
        assertTrue(asset.getAvailability());
        assetHashMaps.put(1,asset);
        library.borrowAsset(1);
        assets.add(library.borrowAsset(1));
        user.setBorrowedBooks(assets);
        //after borrowing
        //assertEquals("Not available",asset.getStatus());


    }
}