package LibrarySystem.library.catalogue;

import LibrarySystem.library.Library;
import LibrarySystem.library.LibraryFactory;
import LibrarySystem.library.PersonException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ThesisDissertationTest {

    private Library library;
    private Author author;
    private ThesisDissertation thesis;
    private ArrayList<String> assetNames;
    @BeforeEach
    void setUp() throws PersonException {
        author = new Author("Robert Boyle");
        thesis = new ThesisDissertation("Distillation",1,author,"Separating Components","some writings ...","1867");
        library = LibraryFactory.createLibrary();
        assetNames = new ArrayList<>();
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
    void getAssetType() {
        assertEquals("Thesis / Dissertation",thesis.getAssetType());
    }

    @Test
    void setQuantity() {
        thesis.setQuantity(5);
        assertEquals(5,thesis.getQuantity());
    }

    @Test
    void setAuthor() throws PersonException {
        Author author1 = new Author("James Brown");
        thesis.setAuthor(author1);
        assertEquals("AuthorName: James Brown",thesis.getAuthor().toString());
    }

    @Test
    void setTopic() {
        thesis.setTopic("Knowledge");
        assertEquals("Knowledge",thesis.getTopic());
    }

    @Test
    void setSummary() {
        thesis.setSummary("Get up, stand up don't give up the fight");
        assertEquals("Get up, stand up don't give up the fight",thesis.getSummary());
    }

    @Test
    void setPublishedDate() {
        thesis.setPublishedDate("1899");
        assertEquals("1899",thesis.getPublishedDate());
    }
    @Test
    void testToString(){
        String expectedString = "Author: Robert Boyle, Topic: Separating Components, Date: 1867";
        assertEquals(expectedString,thesis.toString());
    }

    @Test
    void testGetCreatorName() {
        assertEquals("Robert Boyle",thesis.getAuthor().getName());
    }
}