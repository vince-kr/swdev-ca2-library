package LibrarySystem.interactor;

import LibrarySystem.library.Library;
import LibrarySystem.util.io.StandardInput;

public class AddAuthor extends Interaction {
    String header = "ADD AN AUTHOR\n";
    String prompt = "Please enter the author's name.\nUpper- and lowercase letters, spaces, and hyphens are allowed: ";
    String responsePattern = "^[\\p{L} -]+$";
    String confirmation = "SUCCESS - new author added!";

    @Override
    public void requestAndResponse(Library library) {
        System.out.println(header);

        String authorName = StandardInput.getValidString(prompt, responsePattern);
        library.addAuthor(authorName);

        System.out.println(confirmation);
    }
}
