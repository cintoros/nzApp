package ch.fhnw.nzcrawler;

import java.util.Collection;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Elias Schorr
 * @since 18.09.2015
 */
public class CrawlerTest {

    /**
     * Test of crawl method, of class Crawler.
     */
    @Test
    public void testCrawl() {
        System.out.println("crawl");
        Crawler instance = new Crawler();
        Collection<News> crawl = instance.crawl();
        if (crawl == null) {
            fail("The crawling failed. No Opject returned");
        } else {
            for (News crawl1 : crawl) {
                crawl1.toString();
            }
        }
    }

}
