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

    @RequestMapping("/crawl")

    public String crawl() {
        System.out.println("crawl");
        try {
            new Crawler(newsRepo).crawl();
        } catch (Exception e) {
            return "Failed";
        }
        return "Success";
    }
}
