package LibrarySystem.library;

import LibrarySystem.library.catalogue.Asset;
import LibrarySystem.library.catalogue.AssetRegisterEntry;
import LibrarySystem.library.catalogue.Author;
import LibrarySystem.library.catalogue.BookAudioBook;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class LoanTest {
    private AssetRegisterEntry toBorrow;
    private Asset asset;
    private LibraryUser doingBorrowing;
    private LocalDate dateIssued;
    private LocalDate dateDue;

    private boolean isActive;
    private Loan loan;
    @BeforeEach
    void setUp() throws PersonException {
        int key = 1001;
        isActive = true;
        doingBorrowing = new LibraryUser("John Jones");
        Author author = new Author("King James");
        dateIssued = LocalDate.now();
        dateDue = LocalDate.now().plusDays(21);
        asset = new BookAudioBook("Bible",1,"1-009-89067-9","1678",author);
        toBorrow = new AssetRegisterEntry(key,asset);
        loan = new Loan(doingBorrowing,toBorrow);
    }

    @Test
    void getUser() {
        assertEquals(doingBorrowing,loan.getUser());
    }

    @Test
    void getID() {
        assertEquals(1001,loan.getAssetID());
    }

    @Test
    void getAsset() {
        assertEquals(asset,loan.getAsset());
    }

    @Test
    void getEntry() {
        assertEquals(toBorrow,loan.getEntry());
    }

    @Test
    void getDateDue() {

    }

    @Test
    void isActive() {
        assertEquals(isActive,loan.isActive());
    }

    @Test
    void returnAsset() {
    }

    @Test
    void loanOverdue() {
    }
}