package ch.fhnw.nzcrawler.crawl;

import ch.fhnw.nzcrawler.Settings;
import ch.fhnw.nzcrawler.model.News;
import ch.fhnw.nzcrawler.saver.NewsSaverService;
import java.util.Collection;

/**
 *
 * @author Elias Schorr
 * @since 21.09.2015
 */
public class AutoCrawler extends Thread {

    private final NewsSaverService newsRepo;
    private final CrawlerInterface crawler;

    public AutoCrawler(NewsSaverService newsRepo, CrawlerInterface crawler) {
        this.newsRepo = newsRepo;
        this.crawler = crawler;
    }

    @Override
    public void run() {
        while (Settings.AUTO_CRAWL) {
            System.out.println("auto_crawl");
            Collection<News> crawl = crawler.crawl();
            newsRepo.save(crawl);
            try {
                sleep(Settings.DURATION);
            } catch (InterruptedException ex) {
                System.out.println("interupted sleep");
            }
        }
    }

}
