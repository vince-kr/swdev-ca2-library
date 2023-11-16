package LibrarySystem.library;

import LibrarySystem.library.catalogue.Asset;
import LibrarySystem.library.catalogue.Author;
import LibrarySystem.library.catalogue.BookAudioBook;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddAssetTest {
    Library library = LibraryFactory.createLibrary();
    Author testAuthor = new Author(420, "TP");
    Asset dw1 = new BookAudioBook("The Colour of Magic", "0-86140-324-X", "1983", testAuthor, 1);
    Asset dw2 = new BookAudioBook("The Light Fantastic", "0-86140-203-0", "1986", testAuthor, 1);
    Asset dw3 = new BookAudioBook("Equal Rites", "0-575-03950-7", "1987", testAuthor, 1);

    @Test
    @DisplayName("Call public method to add asset")
    void testAddAsset() {
        library.addAsset(dw1);
    }

    @Test
    @DisplayName("After adding an asset, library reports total assets is 1")
    void givenLibrary_whenAssetIsAdded_thenTotalAssetsIsOne() {
        library.addAsset(dw2);

        int actual = library.getAssetCount();
        assertEquals(1, actual);
    }

    @Test
    @DisplayName("After adding three assets, library reports total assets is 3")
    void givenLibrary_whenThreeAssetsAdded_thenTotalAssetsIsThree() {
        library.addAsset(dw1);
        library.addAsset(dw2);
        library.addAsset(dw3);

        int actual = library.getAssetCount();
        assertEquals(3, actual);
    }
}
