package LibrarySystem.interactor;

abstract class Interaction implements AskUpdateContinue {
    String nextReference;

    public Interaction() {
        nextReference = "main";
    }

    public String getNextReference() {
        return nextReference;
    }
}
