package LibrarySystem.interactor;

import LibrarySystem.library.Library;
import LibrarySystem.library.LibraryUser;
import LibrarySystem.library.PersonException;
import LibrarySystem.util.io.StandardInput;

public class AddUser extends Interaction {
    String header = "ADD A LIBRARY CUSTOMER\n";
    String prompt = "Please enter the new user's full name: ";
    String responsePattern = "^[\\p{L} '-]+$";

    @Override
    public void requestAndResponse(Library library) {
        System.out.println(header);

        String newUserFullName = StandardInput.getValidString(prompt, responsePattern);

        try {
            library.addUser(new LibraryUser(newUserFullName));
            System.out.println("User " + newUserFullName + " added successfully!\n");

        } catch (PersonException pe) {
            System.out.println(pe.getMessage());
        }
    }
}
