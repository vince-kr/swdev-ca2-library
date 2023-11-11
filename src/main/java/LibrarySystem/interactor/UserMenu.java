package LibrarySystem.interactor;

public class UserMenu extends Menu {
    public UserMenu() {
        header = "USER MENU\n";
        menu = new MenuItem[]{
                new MenuItem("ADD customer", "add-customer"),
                new MenuItem("DEACTIVATE customer", "deactivate-customer"),
                new MenuItem("Back", "main")
        };
    }
}
