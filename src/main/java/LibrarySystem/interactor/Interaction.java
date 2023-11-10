package LibrarySystem.interactor;

abstract class Interaction implements GetUpdateContinue {
    String nextReference;

    public Interaction() {
        nextReference = "main";
    }

    public String getNextReference() {
        return nextReference;
    }
}
