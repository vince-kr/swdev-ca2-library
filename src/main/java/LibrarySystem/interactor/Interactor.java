package LibrarySystem.interactor;

import LibrarySystem.library.Library;

import java.util.HashMap;

class Interactor {
    Interaction currentInteraction;
    final HashMap<String, Interaction> allInteractions;
    boolean isFinished;

    public Interactor() {
        allInteractions = loadAllInteractions();
        currentInteraction = allInteractions.get("main");
    }

    private HashMap<String, Interaction> loadAllInteractions() {
        var allInteractions = new HashMap<String, Interaction>();
        allInteractions.put("main", createMainMenu());
        allInteractions.put("common-operations", createOperationsMenu());
        allInteractions.put("common-filters", createFiltersMenu());
        allInteractions.put("manage-catalogue", createCatalogueMenu());
        allInteractions.put("manage-users", createUserMenu());
        allInteractions.put("load-sample-data", new loadSampleData());
        allInteractions.put("add-asset", new addAsset());
        allInteractions.put("add-author", new AddAuthor());
        allInteractions.put("all-assets", new ListAllAssets());
        return allInteractions;
    }

    private Menu createMainMenu() {
        return new Menu("MAIN MENU\n", new MenuItem[] {
                new MenuItem("OPERATIONS", "common-operations"),
                new MenuItem("LISTS", "common-filters"),
                new MenuItem("CATALOGUE management", "manage-catalogue"),
                new MenuItem("USER management", "manage-users"),
                new MenuItem("SAMPLE data", "load-sample-data"),
                new MenuItem("Exit", "exit")
        });
    }

    private Menu createOperationsMenu() {
        return new Menu("OPERATIONS\n", new MenuItem[] {
                new MenuItem("BORROW asset", "borrow-asset"),
                new MenuItem("RETURN asset", "return-asset"),
                new MenuItem("Back", "main")
        });
    }

    private Menu createFiltersMenu() {
        return new Menu("LISTS\n", new MenuItem[] {
                new MenuItem("all BORROWED", "all-borrowed"),
                new MenuItem("CREATED BY", "created-by"),
                new MenuItem("BORROWED BY", "borrowed-by"),
                new MenuItem("ALL OVERDUE", "all-overdue"),
                new MenuItem("ALL assets", "all-assets"),
                new MenuItem("Back", "main")
        });
    }

    private Menu createCatalogueMenu() {
        return new Menu("MANAGE ASSETS\n", new MenuItem[]{
                new MenuItem("ADD asset", "add-asset"),
                new MenuItem("REMOVE asset", "remove-asset"),
                new MenuItem("add AUTHOR", "add-author"),
                new MenuItem("Back", "main")
        });
    }

    private Menu createUserMenu() {
        return new Menu("USER MENU\n", new MenuItem[]{
                new MenuItem("ADD customer", "add-customer"),
                new MenuItem("DEACTIVATE customer", "deactivate-customer"),
                new MenuItem("Back", "main")
        });
    }

    public void completeRequestResponseCycle(Library library) {
        currentInteraction.requestAndResponse(library);
        String interactionReference = currentInteraction.getNextReference();
        this.currentInteraction = allInteractions.get(interactionReference);
        isFinished = (this.currentInteraction == null);
    }

    public boolean userIsFinished() {
        return isFinished;
    }
}
