package LibrarySystem.library.catalogue;

public class CdDvd extends Asset{
    private Producer producer;
    private Director director;
    private int playtimeInSeconds;

    public CdDvd(String title) {
        super(title);
    }

    public CdDvd(String title,  Producer producer, Director director, int playtimeInSeconds) {
        super(title);
        this.producer = producer;
        this.director = director;
        this.playtimeInSeconds = playtimeInSeconds;
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

    public int getPlaytimeInSeconds() {
        return playtimeInSeconds;
    }

    public void setPlaytimeInSeconds(int playtimeInSeconds) {
        this.playtimeInSeconds = playtimeInSeconds;
    }

    @Override
    public String toString() {
        return String.format("Title: %s, Producer: %s, PlayTime: %d", getTitle(),producer,playtimeInSeconds);
    }
}
