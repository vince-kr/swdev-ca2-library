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
        allInteractions.put("main", new Menu("MAIN MENU\n", new MenuItem[] {
                new MenuItem("OPERATIONS", "common-operations"),
                new MenuItem("LISTS", "common-filters"),
                new MenuItem("CATALOGUE management", "manage-catalogue"),
                new MenuItem("USER management", "manage-users"),
                new MenuItem("Exit", "exit")
        }));
        allInteractions.put("common-operations", new Menu("OPERATIONS\n", new MenuItem[] {
                new MenuItem("BORROW asset", "borrow-asset"),
                new MenuItem("RETURN asset", "return-asset"),
                new MenuItem("Back", "main")
        }));
        allInteractions.put("common-filters", new Menu("LISTS\n", new MenuItem[] {
                new MenuItem("all BORROWED", "all-borrowed"),
                new MenuItem("CREATED BY", "created-by"),
                new MenuItem("BORROWED BY", "borrowed-by"),
                new MenuItem("ALL OVERDUE", "all-overdue"),
                new MenuItem("ALL assets", "all-assets"),
                new MenuItem("Back", "main")
        }));
        allInteractions.put("manage-catalogue", new Menu("MANAGE ASSETS\n", new MenuItem[]{
                new MenuItem("ADD asset", "add-asset"),
                new MenuItem("REMOVE asset", "remove-asset"),
                new MenuItem("add AUTHOR", "add-author"),
                new MenuItem("Back", "main")
        }));
        allInteractions.put("manage-users", new Menu("USER MENU\n", new MenuItem[]{
                new MenuItem("ADD customer", "add-customer"),
                new MenuItem("DEACTIVATE customer", "deactivate-customer"),
                new MenuItem("Back", "main")
        }));
        allInteractions.put("add-asset", new addAsset());
        allInteractions.put("add-author", new AddAuthor());
        return allInteractions;
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
