package LibrarySystem.library.catalogue;

import LibrarySystem.library.Person;
import LibrarySystem.library.PersonException;

import java.util.ArrayList;

public class Author extends Person{
    private ArrayList<Asset> booksAuthored;


    public Author(String name) throws PersonException {
        super(name);
        this.booksAuthored = new ArrayList<>();
    }

    public ArrayList<Asset> getBooksAuthored() {
        return booksAuthored;
    }

    public void setBooksAuthored(ArrayList<Asset> booksAuthored) {
        this.booksAuthored = booksAuthored;
    }

    @Override
    public String toString() {
        return String.format("AuthorName: %s", getName());
    }


}
