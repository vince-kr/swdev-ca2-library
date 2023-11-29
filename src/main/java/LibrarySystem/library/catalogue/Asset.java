package LibrarySystem.library.catalogue;

public abstract class Asset{
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

    public abstract String getCreatorName();

    public abstract String toString();

    public abstract String getAssetType();
}