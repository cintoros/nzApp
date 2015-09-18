package ch.fhnw.nzcrawler.crawl;

import ch.fhnw.nzcrawler.model.News;
import java.util.Collection;

/**
 *
 * @author Elias Schorr
 */
public interface CrawlerInterface {

    public Collection<News> crawl();
}
