package LibrarySystem.library.catalogue;

import LibrarySystem.library.Person;
import LibrarySystem.library.PersonException;
import LibrarySystem.library.catalogue.Asset;

import java.util.ArrayList;

public class Director extends Person{
    private ArrayList<Asset> assetsDirected;

    public Director(int id, String name) throws PersonException {
        super(id, name);
        this.assetsDirected = new ArrayList<>();
    }

    public ArrayList<Asset> getAssetsDirected() {
        return assetsDirected;
    }

    public void setAssetsDirected(ArrayList<Asset> assetsDirected) {
        this.assetsDirected = assetsDirected;
    }

    @Override
    public String toString() {
        return String.format("DirectorId: %d, DirectorName: %s", getId(), getName());
    }
}