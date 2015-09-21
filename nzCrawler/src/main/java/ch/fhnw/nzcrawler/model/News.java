package ch.fhnw.nzcrawler.model;

/**
 * @author Elias Schorr
 */
public class News {

    private final Long newsId;
    private final String title, undertitle, link, imageLink, language;

    public News(Long newsId, String title, String undertitle, String link, String imageLink, String language) {
        this.newsId = newsId;
        this.title = title;
        this.undertitle = undertitle;
        this.link = link;
        this.imageLink = imageLink;
        this.language = language;
    }

    public News(NewsLang lang, NewsLink link) {
        this.language = lang.getLanguage();
        this.title = lang.getTitle();
        this.undertitle = lang.getUndertitle();
        this.link = link.getLink();
        this.newsId = link.getNewsId();
        this.imageLink = link.getImageLink();
    }

    public Long getNewsId() {
        return newsId;
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
