package LibrarySystem.library;

public class LibraryUser extends Person implements Comparable<LibraryUser>{
    boolean isActive;

    public LibraryUser(String name) throws PersonException {
        super(name);
        this.isActive = true;
    }

    public boolean isActive() {
        return isActive;
    }

    public void deactivate() {
        isActive = false;
    }

    @Override
    public String toString() {
        return String.format("UserName: %s",getName());
    }

    /*
     Compare users by name
    */
    @Override
    public int compareTo(LibraryUser o) {
        return this.getName().compareTo(o.getName());
    }
}
