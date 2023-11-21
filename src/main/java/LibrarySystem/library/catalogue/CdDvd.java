package LibrarySystem.library.catalogue;


import java.time.LocalTime;

public class CdDvd extends Asset {
    private Producer producer;
    private Director director;
    private int playTime;
    private LocalTime dateIssued;
    private LocalTime dateDue;
    private String overDue;
    private String productionYear;
    private int quantity;


    public CdDvd(String title, Producer producer, Director director, int playTime, String productionYear, int quantity) {
        super(title);
        this.producer = producer;
        this.director = director;
        this.playTime = playTime;
        this.productionYear = productionYear;
        this.quantity = quantity;
        this.dateIssued = LocalTime.parse("00:00:00.000");
        this.dateDue = LocalTime.parse("00:00:00.000");
        this.overDue = " - ";
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public LocalTime getDateIssued() {
        return dateIssued;
    }

    public void setDateIssued(LocalTime dateIssued) {
        this.dateIssued = dateIssued;
    }

    public LocalTime getDateDue() {
        return dateDue;
    }

    public void setDateDue(LocalTime dateDue) {
        this.dateDue = dateDue;
    }

    public String getOverDue() {
        return overDue;
    }

    public void setOverDue(String overDue) {
        this.overDue = overDue;
    }

    public int getPlayTime() {
        return playTime;
    }

    public void setPlayTime(int playTime) {
        this.playTime = playTime;
    }

    public String getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(String productionYear) {
        this.productionYear = productionYear;
    }

    @Override
    public String toString() {

        return String.format("Title: %s, Producer: %s, ProductionYear: %s",getTitle(),producer.getName(),productionYear);
    }

    @Override
    public String getAssetType() {
        return "CdDvd";
    }



}
