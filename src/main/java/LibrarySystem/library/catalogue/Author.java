package LibrarySystem.library.catalogue;

import LibrarySystem.library.Person;
import LibrarySystem.library.PersonException;
import LibrarySystem.util.format.StringFormat;

import java.util.HashMap;

public class Author extends Person implements Comparable<Author> {
    public Author(String name) throws PersonException {
        super(name);
    }

    @Override
    public String toString() {
        return String.format("AuthorName: %s", getName());
    }


    /*
     Compare authors by name
    */
    @Override
    public int compareTo(Author o) {
        return this.getName().compareTo(o.getName());
    }
}
