package fhnw.ch.nzapp.news.model;

/**
 * @author Elias Schorr
 */
public class News {
    private Long id;
    private final String title, undertitle, link, imageLink;

    public News() {
        this.title = null;
        this.undertitle = null;
        this.link = null;
        this.imageLink = null;
    }

    public News(String title, String undertitle, String link, String imageLink) {
        this.title = title;
        this.undertitle = undertitle;
        this.link = link;
        this.imageLink = imageLink;
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

    public String getImageLink() {
        return imageLink;
    }

    @Override
    public String toString() {
        return title + "/n" + undertitle;
    }
}
