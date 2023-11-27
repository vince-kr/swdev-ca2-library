package LibrarySystem.library.catalogue;




public class ThesisDissertation extends Asset{
    private Author author;
    private String topic;
    private String summary;
    private String publishedDate;
    private int quantity;

    public ThesisDissertation(String title, Author author, String topic, String summary, String publishedDate,int quantity) {
        super(title);
        this.author = author;
        this.topic = topic;
        this.summary = summary;
        this.publishedDate = publishedDate;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }


    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    @Override
    public String getCreatorName() {
        return author.getName();
    }

    @Override
    public String toString() {
        return String.format("Author: %s, Topic: %s, Date: %s", author.getName(),topic,getPublishedDate());
    }

    @Override
    public String getAssetType() {
        return "Thesis";
    }




}
