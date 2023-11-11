package LibrarySystem.interactor;

import LibrarySystem.library.Library;

import java.util.HashMap;

class Interactor {
    GetUpdateContinue currentInteraction;
    HashMap<String, GetUpdateContinue> allInteractions;
    boolean isFinished;

    public Interactor() {
        allInteractions = loadAllInteractions();
        currentInteraction = allInteractions.get("main");
    }

    private HashMap<String, GetUpdateContinue> loadAllInteractions() {
        var allInteractions = new HashMap<String, GetUpdateContinue>();
        allInteractions.put("main", new MainMenu());
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
