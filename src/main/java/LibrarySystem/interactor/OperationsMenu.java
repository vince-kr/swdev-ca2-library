package LibrarySystem.interactor;

public class OperationsMenu extends Menu {
    public OperationsMenu() {
        header = "OPERATIONS\n";
        menu = new MenuItem[] {
                new MenuItem("BORROW asset", "borrow-asset"),
                new MenuItem("RETURN asset", "return-asset"),
                new MenuItem("Back", "main")
        };
    }
}
