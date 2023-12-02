package LibrarySystem.library.catalogue;

import LibrarySystem.library.Library;
import LibrarySystem.library.LibraryFactory;
import LibrarySystem.library.PersonException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CdDvdTest {
    private Library library;
    private Producer producer;
    private Director director;
    private CdDvd cd;
    private ArrayList<String> assetNames;


    @BeforeEach
    void setUp() throws PersonException {
        producer = new Producer("Kevin Costner");
        director = new Director("Harry Barnes");
        cd = new CdDvd("Life",1,producer,director,3000,"1990");
        assetNames = new ArrayList<>();
        library = LibraryFactory.createLibrary();
    }

    @Test
    void getQuantity() {
        assertEquals(1,cd.getQuantity());
    }

    @Test
    void getTitle(){
     assertEquals("Life",cd.getTitle());
    }

    @Test
    void getProducer() {
        assertEquals(producer,cd.getProducer());
    }

    @Test
    void getDirector() {
        assertEquals(director,cd.getDirector());
    }


    @Test
    void getPlayTime() {
        assertEquals(3000,cd.getPlayTime());
    }

    @Test
    void getProductionYear() {
        assertEquals("1990",cd.getProductionYear());
    }


    @Test
    void testToString() {
        String expectedString = "Title: Life, Producer: Kevin Costner, ProductionYear: 1990";
        assertEquals(expectedString,cd.toString());
    }

    @Test
    void getAssetType() {
        assertEquals("Cd / Dvd",cd.getAssetType());
    }


    @Test
    void setTitle(){
        cd.setTitle("Great is the Lord");
        assertEquals("Great is the Lord",cd.getTitle());
    }
    @Test
    void setQuantity() {
        cd.setQuantity(5);
        assertEquals(5,cd.getQuantity());
    }

    @Test
    void setProducer() throws PersonException {
        Producer producer1 = new Producer("George Bush");
        cd.setProducer(producer1);
        assertEquals("ProducerName: George Bush",cd.getProducer().toString());
    }



    @Test
    void setDirector() throws PersonException {
        Director director1 = new Director("Garry Coleman");
        cd.setDirector(director1);
        assertEquals("DirectorName: Garry Coleman",cd.getDirector().toString());
    }



    @Test
    void setPlayTime() {
        cd.setPlayTime(45000);
        assertEquals(45000,cd.getPlayTime());
    }

    @Test
    void setProductionYear() {
        cd.setProductionYear("2000");
        assertEquals("2000",cd.getProductionYear());
    }

    @Test
    void getCreatorName() {
        assertEquals("Harry Barnes",cd.getDirector().getName());
    }

    @Test
    void getSearchableFields(){
        library.addAsset(cd);
        assetNames.add(cd.title);
        assetNames.add(cd.getCreatorName());
        assetNames.add(cd.getAssetType());
        assertEquals(assetNames,cd.getSearchableFields());
    }

}