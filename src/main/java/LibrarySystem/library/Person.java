package LibrarySystem.library;

import java.util.ArrayList;
import java.util.List;

public abstract class Person implements Searchable {
    private String name;

    public Person(String name) throws PersonException {
        if (name.length() < 2 || name.length() >= 30) {
            throw new PersonException("Name should be between 2 and 30 characters in length");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Iterable<String> getSearchableFields() {
        return new ArrayList<>(List.of(this.name));
    }

    public abstract String toString();
    }