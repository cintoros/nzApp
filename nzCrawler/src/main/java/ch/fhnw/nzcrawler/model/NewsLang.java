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
public class NewsLang {

    @Id
    @GeneratedValue
    private Long id;

    private final Long newsId;
    private final String title, undertitle, language;

    public NewsLang() {
        this.newsId = null;
        this.title = null;
        this.undertitle = null;
        this.language = null;
    }

    public NewsLang(Long linkId, String title, String undertitle, String language) {
        this.newsId = linkId;
        this.title = title;
        this.undertitle = undertitle;
        this.language = language;
    }

    public Long getNewsId() {
        return newsId;
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

    public String getLanguage() {
        return language;
    }

}
