package LibrarySystem.library.catalogue;

import LibrarySystem.library.PersonException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ProducerTest {
    private Producer producer;
    private CdDvd cd;

    @BeforeEach
    void setUp() throws PersonException {
        Director director = new Director("Steve Jobs");
        producer = new Producer("Angela McDonald");
        cd = new CdDvd("Ever Loving",1,producer,director,45000,"1979");
    }

    @Test
    void getAssetProduced() {
        ArrayList<Asset> assets = new ArrayList<>();
        assets.add(cd);
        producer.setAssetProduced(assets);
        assertEquals(1,producer.getAssetProduced().size());
    }

    @Test
    void setAssetProduced() {
        ArrayList<Asset> assets = new ArrayList<>();
        assets.add(cd);
        producer.setAssetProduced(assets);
        assertEquals(1,producer.getAssetProduced().size());
    }

    @Test
    void testToString() {
        assertEquals("ProducerName: Angela McDonald",producer.toString());
    }
}