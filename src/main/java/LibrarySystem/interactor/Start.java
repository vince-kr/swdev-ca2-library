package interactor;

import library.Library;
import library.LibraryFactory;

public class Start {
    public static void Main(String[] args) {
        // First things first: tell the user what the system is for
        System.out.println("===========================\n" +
                "!!  LIBRARY  MANAGEMENT  !!\n" +
                "===========================\n");

        // Create a new object that implements the Library interface
        // This is coming from another package, so we're using a static factory to avoid having
        // to make the LibraryManagement (plus other classes that it uses) public
        // The Library object (and the Catalogue object that it uses) know everything about maintaining
        // users, assets, authors, etc
        Library library = LibraryFactory.createLibrary();

        // Create a new Interactor object - this is coming from our current package, so no need
        // to make it more complicated with a factory
        // The Interactor object knows everything about interacting with the user: showing them
        // menus, prompts, and other output
        Interactor ui = new Interactor();

        // Start our main loop: this will continue running until the return value from the
        // userIsFinished() method becomes false
        while(!ui.userIsFinished()) {
            // A complete request-response cycle means: first we give the user some menu or
            // prompt, then we parse their response, and finally we take some action on the Library
            // object if applicable. The library object is passed into the request-response cycle
            // for this purpose.
            ui.completeRequestResponseCycle(library);
        }
    }
}
