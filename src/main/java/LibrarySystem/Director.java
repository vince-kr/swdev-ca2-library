package LibraryCatalogue;

import java.util.ArrayList;

public class Director extends Person{
    private  String name;
    private ArrayList<Asset> thingsDirected;

    public Director(String name) {
        super(name);
    }

    public Director(String name, String name1, ArrayList<Asset> thingsDirected) {
        super(name);
        this.name = name1;
        this.thingsDirected = thingsDirected;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Asset> getThingsDirected() {
        return thingsDirected;
    }

    public void setThingsDirected(ArrayList<Asset> thingsDirected) {
        this.thingsDirected = thingsDirected;
    }

    @Override
    public String toString() {
        return null;
    }
}
