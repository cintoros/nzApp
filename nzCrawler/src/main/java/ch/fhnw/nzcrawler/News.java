package ch.fhnw.nzcrawler;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * class representing a News
 *
 * @author Elias Schorr
 */
@Entity
public class News {

    @Id
    @GeneratedValue
    private Long id;
    private final String title, undertitle, link;

    /**
     * standard constructor
     */
    public News() {
        this.title = "no title";
        this.undertitle = "no undertitle";
        this.link = "no link";
    }

    /**
     * constructor that inits all variables
     *
     * @param title
     * @param undertitle
     * @param link
     */
    public News(String title, String undertitle, String link) {
        this.title = title;
        this.undertitle = undertitle;
        this.link = link;
    }

    /**
     * gives back the id of the News
     *
     * @return
     */
    public Long getId() {
        return id;
    }

    /**
     * gives back the title of the News
     *
     * @return
     */
    public String getTitle() {
        return title;
    }

    /**
     * gives back the untertitle of the News
     *
     * @return
     */
    public String getUndertitle() {
        return undertitle;
    }

    /**
     * gives back the link of the News
     *
     * @return
     */
    public String getLink() {
        return link;
    }

}
