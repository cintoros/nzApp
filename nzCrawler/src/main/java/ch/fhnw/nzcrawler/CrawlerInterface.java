package ch.fhnw.nzcrawler;

import java.util.Collection;

/**
 *
 * @author Elias Schorr
 */
public interface CrawlerInterface {

    public Collection<News> crawl();
}
