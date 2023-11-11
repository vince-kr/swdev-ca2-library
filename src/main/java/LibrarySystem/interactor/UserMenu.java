package LibrarySystem.interactor;

public class UserMenu extends Menu {
    public UserMenu() {
        header = "USER MENU\n";
        menu = new MenuItem[]{
                new MenuItem("Add a user", "add-user"),
                new MenuItem("Back", "main")
        };
    }
}
