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
        allInteractions.putAll(buildMainMenuWithOptions());
        allInteractions.putAll(buildOperationsMenuWithOptions());
        allInteractions.putAll(buildFiltersMenuWithOptions());
        allInteractions.putAll(buildCatalogueMenuWithOptions());
        allInteractions.putAll(buildUserMenuWithOptions());
        allInteractions.putAll(buildFileOperationMenuOptions());
        return allInteractions;
    }

    private HashMap<String, Interaction> buildMainMenuWithOptions() {
        var mainMenuInteractions = new HashMap<String, Interaction>();
        mainMenuInteractions.put("main", createMainMenu());
        mainMenuInteractions.put("load-sample-data", new LoadSampleData());
        return mainMenuInteractions;
    }

    private Menu createMainMenu() {
        return new Menu("MAIN MENU\n", new MenuItem[] {
                new MenuItem("OPERATIONS", "common-operations"),
                new MenuItem("LISTS", "common-filters"),
                new MenuItem("CATALOGUE management", "manage-catalogue"),
                new MenuItem("USER management", "manage-users"),
                new MenuItem("SAMPLE data", "load-sample-data"),
                new MenuItem("FILE OPERATIONS","file-menu"),
                new MenuItem("Exit", "exit")
        });
    }

    private HashMap<String, Interaction> buildOperationsMenuWithOptions() {
        var operationsMenuInteractions = new HashMap<String, Interaction>();
        operationsMenuInteractions.put("common-operations", createOperationsMenu());
        operationsMenuInteractions.put("borrow-asset", new BorrowAsset());
        return operationsMenuInteractions;
    }

    private Menu createOperationsMenu() {
        return new Menu("OPERATIONS\n", new MenuItem[] {
                new MenuItem("BORROW asset", "borrow-asset"),
                new MenuItem("RETURN asset", "return-asset"),
                new MenuItem("Back", "main")
        });
    }

    private HashMap<String, Interaction> buildFiltersMenuWithOptions() {
        var filtersMenuInteractions = new HashMap<String, Interaction>();
        filtersMenuInteractions.put("common-filters", createFiltersMenu());
        filtersMenuInteractions.put("all-assets", new ListAllAssets());
        filtersMenuInteractions.put("all-borrowed", new ListBorrowedAssets());
        return filtersMenuInteractions;
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

    private HashMap<String, Interaction> buildCatalogueMenuWithOptions() {
        var catalogueMenuInteractions = new HashMap<String, Interaction>();
        catalogueMenuInteractions.put("manage-catalogue", createCatalogueMenu());
        catalogueMenuInteractions.put("add-asset", new AddAsset());
        return catalogueMenuInteractions;
    }

    private Menu createCatalogueMenu() {
        return new Menu("MANAGE ASSETS\n", new MenuItem[]{
                new MenuItem("ADD asset", "add-asset"),
                new MenuItem("REMOVE asset", "remove-asset"),
                new MenuItem("Back", "main")
        });
    }

    private HashMap<String, Interaction> buildFileOperationMenuOptions(){
        var fileOperationMenu = new HashMap<String, Interaction>();
        fileOperationMenu.put("file-menu", createFileOperationMenu());
        fileOperationMenu.put("authors-to-file", new AuthorsToFile());
        fileOperationMenu.put("assets-to-file", new BooksToFile());
        return fileOperationMenu;
    }
    private Menu createFileOperationMenu(){
        return new Menu("FILE OPERATIONS\n", new MenuItem[]{
           new MenuItem("Authors TO File", "authors-to-file"),
                new MenuItem("Assets To File","assets-to-file"),
                new MenuItem("Back","main")
        });
    }
    private HashMap<String, Interaction> buildUserMenuWithOptions() {
        var userMenuInteractions = new HashMap<String, Interaction>();
        userMenuInteractions.put("manage-users", createUserMenu());
        userMenuInteractions.put("add-customer", new AddUser());
        return userMenuInteractions;
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
