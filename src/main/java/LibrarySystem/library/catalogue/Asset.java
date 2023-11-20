package LibrarySystem.library.catalogue;


public abstract class Asset{
    private String title;
    private String status;


    public Asset(String title) {
        this.title = title;
        this.status = "available";
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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