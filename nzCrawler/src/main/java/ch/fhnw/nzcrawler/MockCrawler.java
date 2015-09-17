package ch.fhnw.nzcrawler;

import java.util.Arrays;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 *
 * @author Elias Schorr
 */
@Service
@Profile("dev")
public class MockCrawler implements CrawlerInterface {

    @Override
    public void crawl(NewsRepo newsRepo) {
        Arrays.asList("news_1,news_2,news_3".split(","))
                .forEach(a -> {
                    News account = newsRepo.save(new News(a, a + " untertitle", "www.nzzz.ch/" + a, "DE"));
                });
    }
}
