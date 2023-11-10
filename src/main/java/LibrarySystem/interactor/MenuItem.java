package LibrarySystem.interactor;

public record MenuItem(String description, String menuReference) {

    public String toString() {
        return description;
    }
}
