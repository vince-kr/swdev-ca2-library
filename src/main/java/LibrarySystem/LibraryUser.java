package LibrarySystem;

import java.util.ArrayList;

public class LibraryUser extends Person{
    private int id;
    private String name;
    private ArrayList<Asset> borrowedAsset;

    public LibraryUser(String name) {
        super(name);
    }

    public LibraryUser(String name, int id, String name1) {
        super(name);
        this.id = id;
        this.name = name1;
        this.borrowedAsset = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Asset> getBorrowedAsset() {
        return borrowedAsset;
    }

    public void setBorrowedAsset(ArrayList<Asset> borrowedAsset) {
        this.borrowedAsset = borrowedAsset;
    }

    @Override
    public String toString() {
        return name;
    }
}
