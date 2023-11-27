package LibrarySystem.library.catalogue;


import java.time.LocalDateTime;

public abstract class Asset{
    private String title;
    private boolean isAvailable;
    private LocalDateTime dateIssued;
    private LocalDateTime dateDue;
    private String overDue;
    private int quantity;


    public Asset(String title) {
        this.title = title;
        this.isAvailable = true;
        this.dateIssued = LocalDateTime.now();
        this.dateDue = LocalDateTime.now();
        this.overDue = " - ";
        this.quantity = 1;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDateTime getDateIssued() {
        return dateIssued;
    }

    public void setDateIssued(LocalDateTime dateIssued) {
        this.dateIssued = dateIssued;
    }

    public LocalDateTime getDateDue() {
        return dateDue;
    }

    public void setDateDue(LocalDateTime dateDue) {
        this.dateDue = dateDue;
    }

    public String getOverDue() {
        return overDue;
    }

    public void setOverDue(String overDue) {
        this.overDue = overDue;
    }

    public boolean getAvailability() {
        return isAvailable;
    }

    public void setAvailability(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public abstract String getCreatorName();

    public abstract String toString();
    public abstract String getAssetType();
}