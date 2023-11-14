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
        allInteractions.put("main", new MainMenu());
        allInteractions.put("common-operations", new OperationsMenu());
        allInteractions.put("common-filters", new FiltersMenu());
        allInteractions.put("manage-catalogue", new CatalogueMenu());
        allInteractions.put("manage-users", new UserMenu());
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
