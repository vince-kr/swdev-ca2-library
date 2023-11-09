package LibrarySystem;

import java.util.ArrayList;

public class Producer extends Person{
    private String name;
    private ArrayList<Asset> thingsProduced;

    public Producer(String name) {
        super(name);
    }

    public Producer(String name, String name1, ArrayList<Asset> thingsProduced) {
        super(name);
        this.name = name1;
        this.thingsProduced = thingsProduced;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Asset> getThingsProduced() {
        return thingsProduced;
    }

    public void setThingsProduced(ArrayList<Asset> thingsProduced) {
        this.thingsProduced = thingsProduced;
    }

    @Override
    public String toString() {
        return name;
    }
}
