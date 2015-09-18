package ch.fhnw.nzcrawler;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Elias Schorr
 */
@RestController
public class CrawlController {

    @Autowired
    NewsSaverService newsSaver;
    @Autowired
    CrawlerInterface crawler;

    @RequestMapping("/crawl")
    public String crawl() {
        System.out.println("crawl");
        try {
            Collection<News> crawl = crawler.crawl();
            newsSaver.save(crawl);
        } catch (Exception e) {
            System.err.println(e);
            return "Failed";
        }
        return "Success";
    }
}
