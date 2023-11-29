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
        author = new Author("King James");
        author1 = new Author("John Doe");
        book = new BookAudioBook("Holy Bible","0-438-98147-1","1999",author);
        book1 = new BookAudioBook("Life","1-098-99632-9","1980",author);
    }


    @Test
    void inCorrectName() throws PersonException {
        assertThrowsExactly(
                PersonException.class,() -> new Author("J"),"Name should be between 2 and 30 characters in length");
    }

    @Test
    void getBooksAuthored() {
        author.setBooksAuthored(book);
        author.setBooksAuthored(book1);
        assertEquals(2,author.getBooksAuthored().size());
    }

    @Test
    void setBooksAuthored() {
        author.setBooksAuthored(book);
        assertEquals(1,author.getBooksAuthored().size());
    }

    @Test
    void setName(){
        author.setName("Michael Jordan");
        assertEquals("Michael Jordan",author.getName());
    }
    @Test
    void testToString() {
        assertEquals("AuthorName: King James",author.toString());
    }

    @Test
    void compareTo() {
        //given two authors with no books authored yet
        assertEquals(0,author.compareTo(author1));
        //after one author authored two books and the other none
        author.setBooksAuthored(book);

        assertEquals(1,author.compareTo(author1));
    }

}