package LibrarySystem.interactor;

public class FiltersMenu extends Menu {
    public FiltersMenu() {
        header = "LISTS";
        menu = new MenuItem[] {
                new MenuItem("all BORROWED", "all-borrowed"),
                new MenuItem("CREATED BY", "created-by"),
                new MenuItem("BORROWED BY", "borrowed-by"),
                new MenuItem("ALL OVERDUE", "all-overdue"),
                new MenuItem("ALL assets", "all-assets"),
                new MenuItem("Back", "main")
        };
    }
}
