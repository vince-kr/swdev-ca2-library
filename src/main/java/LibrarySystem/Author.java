package LibraryCatalogue;

import java.util.ArrayList;

public class Author extends Person{
    private String name;
    private ArrayList<Asset> thingsWritten;

    public Author(String name) {
        super(name);
    }

    public Author(String name, ArrayList<Asset> thingsWritten) {
        super(name);
        this.thingsWritten = thingsWritten;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Asset> getThingsWritten() {
        return thingsWritten;
    }

    public void setThingsWritten(ArrayList<Asset> thingsWritten) {
        this.thingsWritten = thingsWritten;
    }

    @Override
    public String toString() {
        return name;
    }

}
