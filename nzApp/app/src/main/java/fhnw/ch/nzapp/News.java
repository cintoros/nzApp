package fhnw.ch.nzapp;

/**
 * @author Elias Schorr
 */
public class News {
    private Long id;
    private final String title, undertitle, link;

    public News() {
        this.title = "no title";
        this.undertitle = "no undertitle";
        this.link = "no link";
    }

    public News(String title, String undertitle, String link) {
        this.title = title;
        this.undertitle = undertitle;
        this.link = link;
    }

    public Long getId() {
        return id;
    }


    public String getTitle() {
        return title;
    }

    public String getUndertitle() {
        return undertitle;
    }

    public String getLink() {
        return link;
    }

    @Override
    public String toString() {
        return title + "/n" + undertitle;
    }
}
