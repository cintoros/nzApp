package ch.fhnw.nzcrawler;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Elias Schorr
 * @since 18.09.2015
 */
@Entity
public class NewsLink {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final Long id;
    private final String link, imageLink;

    public NewsLink() {
        this.id = null;
        this.link = null;
        this.imageLink = null;
    }

    public NewsLink(Long id, String link, String imageLink) {
        this.link = link;
        this.imageLink = imageLink;
        this.id = id;
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
