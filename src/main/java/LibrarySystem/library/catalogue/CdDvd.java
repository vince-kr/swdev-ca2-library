package LibrarySystem.library.catalogue;



public class CdDvd extends Asset {
    private Producer producer;
    private Director director;
    private int playTime;

    private String productionYear;



    public CdDvd(String title, Producer producer, Director director, int playTime, String productionYear) {
        super(title);
        this.producer = producer;
        this.director = director;
        this.playTime = playTime;
        this.productionYear = productionYear;

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
    public String getCreatorName() {
        return director.getName();
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
