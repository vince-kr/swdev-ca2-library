package LibrarySystem.library.catalogue;

import LibrarySystem.library.PersonException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CdDvdTest {
    private Producer producer;
    private Director director;
    private CdDvd cd;


    @BeforeEach
    void setUp() throws PersonException {
        producer = new Producer("Kevin Costner");
        director = new Director("Harry Barnes");
        cd = new CdDvd("Life",producer,director,3000,"1990");
    }

    @Test
    void getProducer() {
        assertEquals(producer,cd.getProducer());
    }

    @Test
    void setProducer() throws PersonException {
        Producer producer1 = new Producer("George Bush");
        cd.setProducer(producer1);
        assertEquals("ProducerName: George Bush",cd.getProducer().toString());
    }

    @Test
    void getDirector() {
        assertEquals(director,cd.getDirector());
    }

    @Test
    void setDirector() throws PersonException {
        Director director1 = new Director("Garry Coleman");
        cd.setDirector(director1);
        assertEquals("DirectorName: Garry Coleman",cd.getDirector().toString());
    }

    @Test
    void getPlayTime() {
        assertEquals(3000,cd.getPlayTime());
    }

    @Test
    void setPlayTime() {
        cd.setPlayTime(45000);
        assertEquals(45000,cd.getPlayTime());
    }

    @Test
    void getProductionYear() {
        assertEquals("1990",cd.getProductionYear());
    }

    @Test
    void setTitle(){
        cd.setTitle("Hero");
        assertEquals("Hero",cd.getTitle());
    }
    @Test
    void setAvailability(){
        cd.setAvailability(false);
        assertEquals(false,cd.getAvailability());
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
    void getAssetType() {
        assertEquals("Cd / Dvd",cd.getAssetType());
    }

    @Test
    void testToString() {
        String expectedString = "Title: Life, Producer: Kevin Costner, ProductionYear: 1990";
        assertEquals(expectedString,cd.toString());
    }
}