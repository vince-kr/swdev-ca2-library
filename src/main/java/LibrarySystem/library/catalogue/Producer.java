package LibrarySystem.library.catalogue;

import java.util.ArrayList;
import LibrarySystem.library.Person;
import LibrarySystem.library.PersonException;
import LibrarySystem.library.catalogue.Asset;

public class Producer extends Person{
    private ArrayList<Asset> assetProduced;


    public Producer(String name) throws PersonException {
        super(name);
        this.assetProduced = new ArrayList<>();
    }

    public ArrayList<Asset> getAssetProduced() {
        return assetProduced;
    }

    public void setAssetProduced(ArrayList<Asset> assetProduced) {
        this.assetProduced = assetProduced;
    }

    @Override
    public String toString() {
        return String.format("ProducerName: %s", getName());
    }
}
