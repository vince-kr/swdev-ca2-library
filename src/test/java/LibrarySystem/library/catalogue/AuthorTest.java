package LibrarySystem.library.catalogue;

import LibrarySystem.library.PersonException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AuthorTest {
    private Author author;
    private BookAudioBook book;
    @BeforeEach
    void setUp() throws PersonException {
        try {
            author = new Author("King James");
        } catch (PersonException e) {
            throw new RuntimeException(e);
        }
        book = new BookAudioBook("Holy Bible","0-438-98147-1","1999",author,1);
    }

    @Test
    void getBooksAuthored() {
        ArrayList<BookAudioBook> books = new ArrayList<>();
        books.add(book);
        author.setBooksAuthored(books);
        assertEquals(1,author.getBooksAuthored().size());
    }
}