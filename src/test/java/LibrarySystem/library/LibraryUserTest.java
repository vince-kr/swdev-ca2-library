package LibrarySystem.library;

import LibrarySystem.library.catalogue.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class LibraryUserTest {
    private Library library;
    private LibraryUser user;
    private LibraryUser user1;
    private BookAudioBook book;
    private ArrayList<String> userNames;
    private CdDvd cd;

    @BeforeEach
    void setUp() throws PersonException {
        user = new LibraryUser("John Doe");
        user1 = new LibraryUser("Kane Doe");
        Producer producer = new Producer("John Jones");
        Director director = new Director("Jane Doe");
        Author author = new Author("Adam Collins");
        book = new BookAudioBook("Ecosystem",1,"0-789-37569-1","1985",author);
        cd = new CdDvd("Life",1,producer,director,3000,"1990");
        library = LibraryFactory.createLibrary();
        userNames = new ArrayList<>();
    }

    @Test
    void getBorrowedBooks() {
        var booksBorrowed = new AssetsRegister();
        booksBorrowed.put(101, book);
        booksBorrowed.put(102, cd);

        library.recordLoan(new Loan(user, new AssetRegisterEntry(101, book)));
        library.recordLoan(new Loan(user, new AssetRegisterEntry(102, cd)));

        assertEquals(booksBorrowed,library.getAssetsForUser(user));
    }

    @Test
    void testToString() {
        assertEquals("UserName: John Doe",user.toString());
    }



    @Test
    void compareTo() {
        // Lexicographical difference between user and user1 should be 1
        // First letters are J and K
        assertEquals(1,user1.compareTo(user));
    }
    @Test
    void getSearchableField(){
        library.addUser(user);
        library.addUser(user1);
        userNames.add(user.getName());
     assertEquals(userNames,user.getSearchableFields());

    }
}