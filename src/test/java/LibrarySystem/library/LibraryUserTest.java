package LibrarySystem.library;

import LibrarySystem.library.catalogue.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class LibraryUserTest {
    private LibraryUser user;
    private LibraryUser user1;

    private BookAudioBook book;
    private CdDvd cd;

    @BeforeEach
    void setUp() throws PersonException {
        user = new LibraryUser("John Doe");
        user1 = new LibraryUser("Jane Doe");
        Producer producer = new Producer("John Jones");
        Director director = new Director("Jane Doe");
        Author author = new Author("Adam Collins");
        book = new BookAudioBook("Ecosystem",1,"0-789-37569-1","1985",author);
        cd = new CdDvd("Life",1,producer,director,3000,"1990");

    }

    @Test
    void getBorrowedBooks() {
        ArrayList<Asset> booksAuthored = new ArrayList<>();
        booksAuthored.add(book);
        booksAuthored.add(cd);
        user.setBorrowedAssets(book);
        user.setBorrowedAssets(cd);
        assertEquals(booksAuthored,user.getBorrowedBooks());
    }

    @Test
    void testToString() {
        assertEquals("UserName: John Doe",user.toString());
    }



    @Test
    void compareTo() {
        ArrayList<Asset> assets = new ArrayList<>();
        //before borrowing assets
        assertEquals(0,user.compareTo(user1));
        assets.add(book);
        assets.add(cd);
        user.setBorrowedAssets(book);
        user.setBorrowedAssets(cd);
        //after borrowing assets
        assertEquals(1,user.compareTo(user1));

    }
}