package LibrarySystem.library.catalogue;

import LibrarySystem.library.PersonException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class BookAudioBookTest {

    private BookAudioBook book;
    private Author author;
    @BeforeEach
    void setUp() throws PersonException {
        author = new Author("king James");
        book = new BookAudioBook("Holy Bible","0-546-77123-9","2000",author,1);
    }

    @Test
    void getQuantity() {
        book.setQuantity(10);
        assertEquals(10, book.getQuantity());
    }

    @Test
    void getDateIssued() {
        LocalTime t1 = LocalTime.now();
        book.setDateIssued(t1);
        assertEquals(t1,book.getDateIssued());
    }

    @Test
    void getDateDue() {
        LocalTime t = LocalTime.now().plusHours(3);
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
}