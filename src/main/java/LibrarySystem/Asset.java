package LibrarySystem;

public abstract class Asset {
    private String title;
    private boolean available;



    public Asset(String title) {
        this.title = title;
        this.available = true;
    }

    public String getTitle() {
        return this.title;
    }

    //borrow asset
    public void borrowAsset(){
        if (available){
            available = false;
        }else{
            System.out.println("Item is already borrowed");
        }
    }

    public boolean isAvailable() {
        return available;
    }



    public abstract String toString();
}
