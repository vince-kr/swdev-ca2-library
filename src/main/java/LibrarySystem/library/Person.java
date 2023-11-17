package LibrarySystem.library;

public abstract class Person {
    private int id;
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
    public abstract String toString();

    }