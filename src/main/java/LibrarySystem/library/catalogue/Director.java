package LibrarySystem.library.catalogue;

import LibrarySystem.library.Person;
import LibrarySystem.library.PersonException;

public class Director extends Person{
    public Director(String name) throws PersonException {
        super(name);
    }

    @Override
    public String toString() {
        return String.format("DirectorName: %s", getName());
    }
}