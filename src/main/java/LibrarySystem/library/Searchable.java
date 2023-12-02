package LibrarySystem.library;

@FunctionalInterface
public interface Searchable {
    Iterable<String> getSearchableFields();
}
