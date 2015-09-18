package ch.fhnw.nzcrawler;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private CrawlerInterface crawler;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner runner(NewsRepo newsRepo) {
        return args -> {
            Collection<News> crawl = crawler.crawl();
            newsRepo.save(crawl);
        };
    }
}
