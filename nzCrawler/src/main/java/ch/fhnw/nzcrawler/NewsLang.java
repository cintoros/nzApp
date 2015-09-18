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
public class NewsLang {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final Long id;
    private final String title, undertitle, language;

    public NewsLang() {
        this.id = null;
        this.title = null;
        this.undertitle = null;
        this.language = null;
    }

    public NewsLang(Long id, String title, String undertitle, String language) {
        this.id = id;
        this.title = title;
        this.undertitle = undertitle;
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

    public String getLanguage() {
        return language;
    }

}
