package LibrarySystem.interactor;

import LibrarySystem.library.Library;
import LibrarySystem.util.io.*;

public class MainMenu extends Interaction {
    final String header = "MAIN MENU\n";
    final MenuItem[] menu = {
            new MenuItem("Add an author", "add-author"),
            new MenuItem("Add an asset", "add-asset"),
            new MenuItem("Exit", "exit")
    };
    final String prompt = "Please make your choice: ";

    @Override
    public void requestAndResponse(Library library) {
        System.out.println(header);

        for (int index = 0; index < menu.length; index++) {
            int fmtIndex = index + 1;
            System.out.println(fmtIndex + ".  " + menu[index]);
        }

        int choice = StandardInput.getPositiveNumber(prompt, menu.length);

        nextReference = menu[--choice].nextInteractionReference();
    }
}
