package ch.fhnw.nzcrawler.crawl;

import ch.fhnw.nzcrawler.model.News;
import java.util.Collection;

/**
 *
 * @author Elias Schorr
 */
public interface CrawlerInterface {

    /**
     * crawls the website
     *
     * @return a Collection of News Objects or null if crawling failed
     */
    public Collection<News> crawl();
}
