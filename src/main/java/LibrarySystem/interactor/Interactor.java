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
        allInteractions.putAll(buildFileReadOperationMenuOptions());
        allInteractions.putAll(buildSearchMenuOptions());
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
                new MenuItem("FILE PRINT OPERATIONS","file-print-menu"),
                new MenuItem("FILE READ OPERATIONS","file-read-menu"),
                new MenuItem("SEARCH MENU","search-menu"),
                new MenuItem("Exit", "exit")
        });
    }

    private HashMap<String, Interaction> buildOperationsMenuWithOptions() {
        var operationsMenuInteractions = new HashMap<String, Interaction>();
        operationsMenuInteractions.put("common-operations", createOperationsMenu());
        operationsMenuInteractions.put("borrow-asset", new BorrowAsset());
        operationsMenuInteractions.put("return-asset",new ReturnAsset());
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
        filtersMenuInteractions.put("all-available", new ListAvailableAssets());
        filtersMenuInteractions.put("all-borrowed", new ListBorrowedAssets());
        filtersMenuInteractions.put("borrowed-by", new ListBorrowedByUser());
        filtersMenuInteractions.put("created-by", new ListCreatedBy());
        return filtersMenuInteractions;
    }

    private Menu createFiltersMenu() {
        return new Menu("LISTS\n", new MenuItem[] {
                new MenuItem("ALL assets", "all-assets"),
                new MenuItem("all AVAILABLE", "all-available"),
                new MenuItem("all BORROWED", "all-borrowed"),
                new MenuItem("all OVERDUE", "all-overdue"),
                new MenuItem("BORROWED by", "borrowed-by"),
                new MenuItem("CREATED by", "created-by"),
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

    private HashMap<String,Interaction> buildSearchMenuOptions(){
        var searchMenuInterface = new HashMap<String,Interaction>();
        searchMenuInterface.put("search-menu", createSearchMenu());
        searchMenuInterface.put("search-user", new SearchUser());
        searchMenuInterface.put("search-asset", new SearchAsset());
        searchMenuInterface.put("search-author",new SearchAuthor());

        return searchMenuInterface;
    }
    private Menu createSearchMenu(){
        return new Menu("SEARCH MENU\n",new MenuItem[]{
                new MenuItem("SEARCH USER","search-user"),
                new MenuItem("SEARCH ASSET","search-asset"),
                new MenuItem("SEARCH AUTHOR","search-author"),
                new MenuItem("Back","main")
        });
    }
    private HashMap<String, Interaction> buildFileOperationMenuOptions(){
        var fileOperationMenu = new HashMap<String, Interaction>();
        fileOperationMenu.put("file-print-menu", createFileOperationMenu());
        fileOperationMenu.put("authors-to-file", new CreatorsToFile());
        fileOperationMenu.put("users-to-file", new UsersToFile());
        fileOperationMenu.put("books-to-file", new BooksToFile());
        fileOperationMenu.put("assets-to-file", new AssetsToFile());
        fileOperationMenu.put("cds-to-file", new CdsToFile());
        fileOperationMenu.put("thesis-to-file", new ThesisToFile());
        return fileOperationMenu;
    }
    private Menu createFileOperationMenu(){
        return new Menu("FILE PRINT OPERATIONS\n", new MenuItem[]{
           new MenuItem("Authors TO File", "authors-to-file"),
                new MenuItem("Users TO File","users-to-file"),
                new MenuItem("Assets To File","assets-to-file"),
                new MenuItem("Books TO File","books-to-file"),
                new MenuItem("Cds TO File","cds-to-file"),
                new MenuItem("Thesis To File","thesis-to-file"),
                new MenuItem("Back","main")
        });
    }

    private HashMap<String,Interaction> buildFileReadOperationMenuOptions(){
        var fileReadOperationMenu = new HashMap<String,Interaction>();
        fileReadOperationMenu.put("file-read-menu", createFileReadOperationMenu());
        fileReadOperationMenu.put("authors-from-file",new ReadFromAuthor());
        fileReadOperationMenu.put("users-from-file",new UsersFromFile());
        fileReadOperationMenu.put("books-from-file",new ReadFromBook());
        fileReadOperationMenu.put("cds-from-file", new ReadFromCd());
        fileReadOperationMenu.put("thesis-from-file",new ReadFromThesis());
        return fileReadOperationMenu;
    }

    private Menu createFileReadOperationMenu(){
        return new Menu("FILE READ OPERATIONS\n",new MenuItem[]{
                new MenuItem("AUTHORS FROM FILE","authors-from-file"),
                new MenuItem("USERS FROM FILE","users-from-file"),
                new MenuItem("BOOKS FROM FILE","books-from-file"),
                new MenuItem("CDS FROM FILE","cds-from-file"),
                new MenuItem("THESIS FROM FILE","thesis-from-file"),
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
