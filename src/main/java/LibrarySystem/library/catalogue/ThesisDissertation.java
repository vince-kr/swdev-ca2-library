package LibrarySystem.library.catalogue;

import java.util.Date;

public class ThesisDissertation extends WrittenThing{
    private String title;
    private String summary;

    public ThesisDissertation(Date publishedDate) {
        super(String.valueOf(publishedDate));
    }

    public ThesisDissertation(Date publishedDate, String title, String summary) {
        super(String.valueOf(publishedDate));
        this.title = title;
        this.summary = summary;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    @Override
    public String toString() {
        return String.format("Title: %s, Summary: %s", title, summary);
    }
}
