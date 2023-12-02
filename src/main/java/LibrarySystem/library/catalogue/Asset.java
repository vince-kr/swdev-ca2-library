package LibrarySystem.library.catalogue;

import LibrarySystem.library.Searchable;

import java.util.*;

public abstract class Asset implements Searchable {
    String title;
    int quantity;

    public Asset(String title, int quantity) {
        this.title = title;
        this.quantity = quantity;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public Iterable<String> getSearchableFields() {
        return () -> Arrays.asList(
                this.title,
                this.getCreatorName(),
                this.getAssetType()
                )
                .iterator();
    }

    public abstract String getCreatorName();

    public abstract String toString();

    public abstract String getAssetType();
}