package LibrarySystem.interactor;

import LibrarySystem.library.Library;

public class MainMenu extends Menu {
    public MainMenu() {
        header = "MAIN MENU\n";
        menu = new MenuItem[]{
                new MenuItem("Manage USERS", "user-management"),
                new MenuItem("Manage ASSETS", "asset-management"),
                new MenuItem("Exit", "exit")
        };
    }
}
