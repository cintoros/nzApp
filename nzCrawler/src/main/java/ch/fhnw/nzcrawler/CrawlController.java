package ch.fhnw.nzcrawler;

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
            crawler.crawl(newsRepo);
        } catch (Exception e) {
            return "Failed";
        }
        return "Success";
    }
}
