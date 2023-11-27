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




    @BeforeEach
    void setUp() throws PersonException {
        user = new LibraryUser("John Doe");
        Author author = new Author("King James");
        asset = new BookAudioBook("Holy Bible","0-987-12377-7","1867",author);

    }

    @Test
    void requestAndResponse() {
        ArrayList<Asset> assets = user.getBorrowedBooks();
        //before borrowing
        assertTrue(asset.getAvailability());
       int l = user.getBorrowedBooks().size();
        assets.add(asset);
        //after borrowing
        assertEquals(1,user.getBorrowedBooks().size());
        //assertEquals(0,asset.getQuantity());
        //assertEquals(false,user.getBorrowedBooks().get(l).getAvailability());


    }
}