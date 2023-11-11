package LibrarySystem.interactor;

public record MenuItem(String description, String nextInteractionReference) {

    public String toString() {
        return description;
    }
}
