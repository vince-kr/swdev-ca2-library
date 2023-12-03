package LibrarySystem.library.catalogue;

import LibrarySystem.library.Library;
import LibrarySystem.library.LibraryFactory;
import LibrarySystem.library.PersonException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class BookAudioBookTest {

    private Library library;
    private BookAudioBook book;
    private Author author;
    private ArrayList<String> assetNames;

    @BeforeEach
    void setUp() throws PersonException {
        author = new Author("King James");
        book = new BookAudioBook("Holy Bible",1,"0-546-77123-9","2000",author);
        library = LibraryFactory.createLibrary();
        assetNames = new ArrayList<>();
    }

    @Test
    void getQuantity() {
        book.setQuantity(10);
        assertEquals(10, book.getQuantity());
    }


    @Test
    void getIsbn() {
        assertEquals("0-546-77123-9",book.getIsbn());
    }

    @Test
    void getPublishedYear() {
        book.setPublishedYear("1998");
        assertEquals(Integer.parseInt("1998"),Integer.parseInt(book.getPublishedYear()));
    }

    @Test
    void getAuthor() {
        book.setAuthor(author);
        assertEquals(author, book.getAuthor());
    }


    @Test
    void getAssetType() {
        assertEquals("Book / Audiobook",book.getAssetType());
    }

    @Test
    void testGetIsbn() {
        assertEquals("0-546-77123-9",book.getIsbn());
    }

    @Test
    void setIsbn() {
        book.setIsbn("0-556-77123-0");
        assertEquals("0-556-77123-0",book.getIsbn());
    }

    @Test
    void setAuthor() throws PersonException {
        Author author1 = new Author("New King James");
        book.setAuthor(author1);
        assertEquals(author1,book.getAuthor());
    }


    @Test
    void testToString() {
        assertEquals("Title: Holy Bible, Author: King James", book.toString());
    }


    @Test
    void getCreatorName() {
        assertEquals("King James",book.getAuthor().getName());
    }

}