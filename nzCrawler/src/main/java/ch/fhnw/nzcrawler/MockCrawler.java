package ch.fhnw.nzcrawler;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
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
    public Collection<News> crawl() {
        HashSet<News> news = new HashSet<>();
        Arrays.asList("news_1,news_2,news_3".split(",")).forEach(a -> {
            news.add(new News(a, a + " untertitle", "www.example.ch/" + a, "www.example.ch/" + a + "/image.png", "DE"));
        });
        return news;
    }
}
