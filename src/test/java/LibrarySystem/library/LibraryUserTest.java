package LibrarySystem.library;

import LibrarySystem.library.catalogue.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class LibraryUserTest {
    private LibraryUser user;

    private BookAudioBook book;
    private CdDvd cd;

    @BeforeEach
    void setUp() throws PersonException {
        user = new LibraryUser("John Doe");
        Producer producer = new Producer("John Jones");
        Director director = new Director("Jane Doe");
        Author author = new Author("Adam Collins");
        book = new BookAudioBook("Ecosystem","0-789-37569-1","1985",author,1);
        cd = new CdDvd("Life",producer,director,3000,"1990",1);

    }

    @Test
    void getBorrowedBooks() {
        ArrayList<Asset> booksAuthored = new ArrayList<>();
        booksAuthored.add(book);
        booksAuthored.add(cd);
        user.setBorrowedBooks(booksAuthored);
        assertEquals(booksAuthored,user.getBorrowedBooks());
    }

    @Test
    void testToString() {
        assertEquals("UserName: John Doe",user.toString());
    }
}