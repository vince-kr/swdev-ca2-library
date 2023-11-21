package LibrarySystem.library.catalogue;

import LibrarySystem.library.PersonException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class CdDvdTest {
    private Producer producer;
    private Director director;
    private CdDvd cd;

    @BeforeEach
    void setUp() throws PersonException {
        producer = new Producer("Kevin Costner");
        director = new Director("Harry Barnes");
        cd = new CdDvd("Life",producer,director,3000,"1990",1);
    }

    @Test
    void getQuantity() {
        assertEquals(1,cd.getQuantity());
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
    void getDateIssued() {
        LocalTime t1 = LocalTime.now();
        cd.setDateIssued(t1);
        assertEquals(t1,cd.getDateIssued());
    }

    @Test
    void getDateDue() {
        LocalTime t2 = LocalTime.now().plusHours(24);
        cd.setDateDue(t2);
        assertEquals(t2,cd.getDateDue());
    }

    @Test
    void getOverDue() {
        assertEquals(" - ",cd.getOverDue());
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
        assertEquals("CdDvd",cd.getAssetType());
    }
}