package ch.fhnw.nzcrawler;

/**
 *
 * @author Elias Schorr
 * @since 18.09.2015
 */
public class NewsJson {

    private final Long id;
    private final String title, undertitle, link, imageLink, language;

    public NewsJson(NewsLang lang, NewsLink link) {
        this.language = lang.getLanguage();
        this.title = lang.getTitle();
        this.undertitle = lang.getUndertitle();
        this.link = link.getLink();
        this.id = link.getId();
        this.imageLink = link.getImageLink();
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
