package ch.fhnw.nzcrawler.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Elias Schorr
 */
@Entity
public class News {

    @Id
    @GeneratedValue
    private Long id;
    private final String title, undertitle, link, imageLink, language;

    public News() {
        this.title = null;
        this.undertitle = null;
        this.link = null;
        this.language = null;
        this.imageLink = null;
    }

    public News(String title, String undertitle, String link, String imageLink, String language) {
        this.title = title;
        this.undertitle = undertitle;
        this.link = link;
        this.imageLink = imageLink;
        this.language = language;
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

    public String getLanguage() {
        return language;
    }

}
