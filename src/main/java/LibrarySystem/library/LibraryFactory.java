package library;

// The library package only needs two public classes: the Library interface, and the LibraryFactory
// class below. This only has a single static method which simply returns a new LibraryManagement
// object.
// It looks unnecessarily complicated, but there is value in keeping classes package-private as
// much as possible.

public class LibraryFactory {
    public static Library createLibrary() {
        return new LibraryManagement();
    }
}
