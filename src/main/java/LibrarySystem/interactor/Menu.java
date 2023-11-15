package LibrarySystem.interactor;

import LibrarySystem.library.Library;
import LibrarySystem.util.io.StandardInput;

class Menu extends Interaction {
    String header;
    MenuItem[] menu;
    String prompt;

    public Menu(String header, String prompt, MenuItem[] menu) {
        this.header = header;
        this.menu = menu;
        this.prompt = prompt;
    }

    public Menu(String header, MenuItem[] menu) {
        this.header = header;
        this.menu = menu;
        this.prompt = "Please make your choice: ";
    }

    @Override
    public void requestAndResponse(Library library) {
        System.out.println(header);

        for (int index = 0; index < menu.length; index++) {
            int fmtIndex = index + 1;
            System.out.println(fmtIndex + ".  " + menu[index]);
        }

        int choice = StandardInput.getPositiveInt(prompt, menu.length);

        nextReference = menu[choice - 1].nextInteractionReference();
    }
}
