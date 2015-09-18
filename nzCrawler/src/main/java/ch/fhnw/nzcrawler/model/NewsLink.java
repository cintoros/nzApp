package ch.fhnw.nzcrawler.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author Elias Schorr
 * @since 18.09.2015
 */
@Entity
public class NewsLink {

    @Id
    @GeneratedValue
    private Long id;
    private final Long newsId;
    private final String link, imageLink;

    public NewsLink() {
        this.newsId = null;
        this.link = null;
        this.imageLink = null;
    }

    public NewsLink(Long newsId, String link, String imageLink) {
        this.link = link;
        this.imageLink = imageLink;
        this.newsId = newsId;
    }

    public Long getNewsId() {
        return newsId;
    }

    public Long getId() {
        return id;
    }

    public String getLink() {
        return link;
    }

    public String getImageLink() {
        return imageLink;
    }

}
