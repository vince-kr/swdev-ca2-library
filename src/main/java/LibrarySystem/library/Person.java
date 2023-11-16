package LibrarySystem.library;

public abstract class Person {
    private int id;
    private String name;

    public Person(int id, String name) throws PersonException {
        if (name.length() <= 2 || name.length() >= 30) {
            throw new PersonException("Student name should be between 2 and 30 characters in length");
        }
        this.id = id;
        this.name = name;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public abstract String toString();

    }