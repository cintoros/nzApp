package ch.fhnw.nzcrawler;

import ch.fhnw.nzcrawler.crawl.AutoCrawler;
import ch.fhnw.nzcrawler.crawl.CrawlerInterface;
import ch.fhnw.nzcrawler.model.News;
import ch.fhnw.nzcrawler.saver.NewsSaverService;
import java.util.Collection;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 *
 * @author Elias Schorr
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner runner(NewsSaverService newsRepo, CrawlerInterface crawler) {
        return args -> {
            if (Settings.AUTO_CRAWL) {
                AutoCrawler autoCrawler = new AutoCrawler(newsRepo, crawler);
                autoCrawler.start();
            } else {
                Collection<News> crawl = crawler.crawl();
                newsRepo.save(crawl);
            }
        };
    }
}
