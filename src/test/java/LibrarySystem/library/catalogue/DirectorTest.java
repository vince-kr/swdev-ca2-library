package LibrarySystem.library.catalogue;

import LibrarySystem.library.PersonException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DirectorTest {
    private Director director;

    private CdDvd cd;
    @BeforeEach
    void setUp() throws PersonException {
        director = new Director("Steve Jobs");
        Producer producer = new Producer("Angela McDonald");
        cd = new CdDvd("Ever Loving",1,producer,director,45000,"1979");
    }

    @Test
    void getAssetsDirected() {
        ArrayList<Asset> assets = new ArrayList<>();
        assets.add(cd);
        director.setAssetsDirected(assets);
        assertEquals(1, director.getAssetsDirected().size());
    }

    @Test
    void setAssetsDirected() {
        ArrayList<Asset> assets = new ArrayList<>();
        assets.add(cd);
        director.setAssetsDirected(assets);
        assertEquals(1,director.getAssetsDirected().size());
    }

    @Test
    void testToString() {
        assertEquals("DirectorName: Steve Jobs",director.toString());
    }
}