package LibrarySystem.library.catalogue;

import LibrarySystem.library.Printable;

public abstract class Asset implements Printable<Asset>{
    private int id;
    private String title;
    private String status;


    public Asset(int id, String title) {
        this.id = id;
        this.title = title;
        this.status = "available";
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public abstract String toString();
    public abstract String getAssetType();
}