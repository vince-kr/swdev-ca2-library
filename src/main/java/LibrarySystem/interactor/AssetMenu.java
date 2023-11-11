package LibrarySystem.interactor;

public class AssetMenu extends Menu {
    public AssetMenu() {
        header = "ASSET MENU\n";
        menu = new MenuItem[]{
                new MenuItem("Add an asset", "add-asset"),
                new MenuItem("Back", "main")
        };
    }
}
