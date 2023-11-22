package LibrarySystem.library.catalogue;

import LibrarySystem.library.PersonException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AuthorTest {
    private Author author;
    private Author author1;
    private BookAudioBook book;
    private BookAudioBook book1;
    @BeforeEach
    void setUp() throws PersonException {
        try {
            author = new Author("King James");
            author1 = new Author("John Doe");
        } catch (PersonException e) {
            throw new RuntimeException(e);
        }
        book = new BookAudioBook("Holy Bible","0-438-98147-1","1999",author,1);
        book1 = new BookAudioBook("Life","1-098-99632-9","1980",author,1);
    }

    @Test
    void getBooksAuthored() {
        ArrayList<Asset> books = new ArrayList<>();
        books.add(book);
        books.add(book1);
        author.setBooksAuthored(books);
        assertEquals(2,author.getBooksAuthored().size());
    }




    @Test
    void setBooksAuthored() {
        ArrayList<Asset> books = new ArrayList<>();
        books.add(book);
        author.setBooksAuthored(books);
        assertEquals(1,author.getBooksAuthored().size());
    }

    @Test
    void testToString() {
        assertEquals("AuthorName: King James",author.toString());
    }

    @Test
    void compareTo() {
        ArrayList<Asset> books = new ArrayList<>();
        books.add(book);
        books.add(book1);
        //given two authors with no books authored yet
        assertEquals(0,author.compareTo(author1));
        //after one author authored two books and the other none
        author.setBooksAuthored(books);

        assertEquals(1,author.compareTo(author1));

    }
}