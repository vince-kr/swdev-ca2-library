package LibrarySystem.library.catalogue;

import LibrarySystem.library.PersonException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class BookAudioBookTest {

    private BookAudioBook book;
    private Author author;

    @BeforeEach
    void setUp() throws PersonException {
        author = new Author("King James");
        book = new BookAudioBook("Holy Bible","0-546-77123-9","2000",author);
    }

    @Test
    void getQuantity() {
        book.setQuantity(10);
        assertEquals(10, book.getQuantity());
    }

    @Test
    void getDateIssued() {
        LocalDateTime t1 = LocalDateTime.now();
        book.setDateIssued(t1);
        assertEquals(t1,book.getDateIssued());
    }

    @Test
    void getDateDue() {
        LocalDateTime t = LocalDateTime.now().plusHours(3);
        book.setDateDue(t);
        assertEquals(t,book.getDateDue());
    }

    @Test
    void getOverDue() {
        book.setOverDue("OverDue");
        assertEquals("OverDue", book.getOverDue());
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
        assertEquals("book",book.getAssetType());
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