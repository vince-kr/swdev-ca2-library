package LibrarySystem.interactor;

public class CatalogueMenu extends Menu {
    public CatalogueMenu() {
        header = "MANAGE ASSETS\n";
        menu = new MenuItem[]{
                new MenuItem("ADD asset", "add-asset"),
                new MenuItem("REMOVE asset", "remove-asset"),
                new MenuItem("add AUTHOR", "add-author"),
                new MenuItem("Back", "main")
        };
    }
}
