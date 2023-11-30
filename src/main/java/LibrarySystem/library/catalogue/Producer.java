package LibrarySystem.library.catalogue;

import LibrarySystem.library.Person;
import LibrarySystem.library.PersonException;

public class Producer extends Person{
    public Producer(String name) throws PersonException {
        super(name);
    }

    @Override
    public String toString() {
        return String.format("ProducerName: %s", getName());
    }
}
