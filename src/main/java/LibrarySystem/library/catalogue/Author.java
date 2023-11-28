package LibrarySystem.library.catalogue;

import LibrarySystem.library.Person;
import LibrarySystem.library.PersonException;

import java.util.ArrayList;

public class Author extends Person implements Comparable<Author>{
    final private ArrayList<Asset> booksAuthored;


    public Author(String name) throws PersonException {
        super(name);
        this.booksAuthored = new ArrayList<>();
    }

    public ArrayList<Asset> getBooksAuthored() {
        return booksAuthored;
    }

    public void setBooksAuthored(Asset asset) {
        this.booksAuthored.add(asset);
    }

    @Override
    public String toString() {
        return String.format("AuthorName: %s", getName());
    }


    /*
     Compare authors by the number of books
     they have written
     */
    @Override
    public int compareTo(Author o) {
        return Integer.compare(this.booksAuthored.size(),o.booksAuthored.size());
    }
}
