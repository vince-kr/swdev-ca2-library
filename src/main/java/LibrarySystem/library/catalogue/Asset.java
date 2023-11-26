package LibrarySystem.library.catalogue;


import java.time.LocalDateTime;
import java.time.LocalTime;

public abstract class Asset{
    private String title;
    private String status;
    private LocalDateTime dateIssued;
    private LocalDateTime dateDue;
    private String overDue;


    public Asset(String title) {
        this.title = title;
        this.status = "available";
        this.dateIssued = LocalDateTime.parse("2023-1-1T14:00:00");
        this.dateDue = LocalDateTime.parse("2023-1-1T14:00:00");
        this.overDue = " - ";
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