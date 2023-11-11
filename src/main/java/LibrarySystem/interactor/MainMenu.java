package LibrarySystem.interactor;

public class MainMenu extends Menu {
    public MainMenu() {
        header = "MAIN MENU\n";
        menu = new MenuItem[]{
                new MenuItem("OPERATIONS", "common-operations"),
                new MenuItem("LISTS", "common-filters"),
                new MenuItem("CATALOGUE management", "manage-catalogue"),
                new MenuItem("USER management", "manage-users"),
                new MenuItem("Exit", "exit")
        };
    }
}
