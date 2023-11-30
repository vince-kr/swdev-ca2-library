package LibrarySystem.library;

import LibrarySystem.library.catalogue.Asset;
import LibrarySystem.library.catalogue.Author;
import LibrarySystem.library.catalogue.BookAudioBook;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddAssetTest {
    Library library = LibraryFactory.createLibrary();
    Author testAuthor = new Author("TP");
    Asset dw1 = new BookAudioBook("The Colour of Magic", 1,"0-86140-324-X", "1983", testAuthor);
    Asset dw2 = new BookAudioBook("The Light Fantastic", 1,"0-86140-203-0", "1986", testAuthor);
    Asset dw3 = new BookAudioBook("Equal Rites", 1,"0-575-03950-7", "1987", testAuthor);

    public AddAssetTest() throws PersonException {
    }

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

    @Test
    @DisplayName("After adding one asset + on-the-fly author, number of authors is 1")
    void givenNoAuthors_whenOneAuthorAdded_totalAuthorsIsOne() {
        int numberOfAuthors = library.getAllCreators().size();
        assertEquals(0, numberOfAuthors);

        try {
            library.addAuthor("Nelson Mandela");
        } catch (PersonException pe) {}
        int newNumberOfAuthors = library.getAllCreators().size();
        assertEquals(1, newNumberOfAuthors);
    }

    @Test
    @DisplayName("When adding the same author twice, number of authors is 1")
    void givenNoAuthors_whenSameAuthorIsAddedTwice_totalAuthorsIsOne() {
        int numberOfAuthors = library.getAllCreators().size();
        assertEquals(0, numberOfAuthors);

        try {
            library.addAuthor("Alex Horne");
            library.addAuthor("Alex Horne");
        } catch (PersonException pe) {}
        int newNumberOfAuthors = library.getAllCreators().size();
        assertEquals(1, newNumberOfAuthors);
    }
}
