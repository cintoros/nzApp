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
    NewsRepo newsRepo;
    @Autowired
    CrawlerInterface crawler;

    @RequestMapping("/crawl")
    public String crawl() {
        System.out.println("crawl");
        try {
            newsRepo.deleteAll();
            Collection<News> crawl = crawler.crawl();
            newsRepo.save(crawl);
        } catch (Exception e) {
            return "Failed";
        }
        return "Success";
    }
}
