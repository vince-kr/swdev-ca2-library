package LibrarySystem.library.catalogue;

import LibrarySystem.library.PersonException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class ThesisDissertationTest {

    private Author author;
    private ThesisDissertation thesis;
    @BeforeEach
    void setUp() throws PersonException {
        author = new Author("Robert Boyle");
        thesis = new ThesisDissertation("Distillation",author,"Separating Components","some writings ...","1867",1);
    }

    @Test
    void getQuantity() {
        assertEquals(1,thesis.getQuantity());
    }

    @Test
    void getAuthor() {
        assertEquals(author,thesis.getAuthor());
    }

    @Test
    void getTopic() {
        assertEquals("Separating Components",thesis.getTopic());
    }

    @Test
    void getSummary() {
        assertEquals("some writings ...",thesis.getSummary());
    }

    @Test
    void getPublishedDate() {
        assertEquals("1867",thesis.getPublishedDate());
    }

    @Test
    void getDateDue() {
        LocalTime t1 = LocalTime.now().plusHours(3);
        thesis.setDateDue(t1);
        assertEquals(t1,thesis.getDateDue());
    }

    @Test
    void getOverDue() {
        assertEquals(" - ",thesis.getOverDue());
    }

    @Test
    void getAssetType() {
        assertEquals("Thesis",thesis.getAssetType());
    }
}