package ch.fhnw.nzcrawler.crawl;

import ch.fhnw.nzcrawler.Settings;
import ch.fhnw.nzcrawler.model.News;
import java.util.Collection;
import java.util.HashSet;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 *
 * @author Elias Schorr
 */
@Service
@Profile(Settings.DEV)
public class MockCrawler implements CrawlerInterface {

    @Override
    public Collection<News> crawl() {
        HashSet<News> news = new HashSet<>();
        long counter = 1;
        String[] split = "Hallo Welt,Guten Morgen,Guten Abend".split(",");
        for (String text : split) {
            news.add(new News(counter, text, "Er hat " + '"' + text + '"' + " gesagt", null, null, "DE"));
            counter++;
        }
        return news;
    }
}
