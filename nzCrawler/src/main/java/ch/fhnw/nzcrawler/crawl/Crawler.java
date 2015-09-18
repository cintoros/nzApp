package ch.fhnw.nzcrawler.crawl;

import ch.fhnw.nzcrawler.model.News;
import java.util.Collection;
import java.util.HashSet;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 *
 * @author Elias Schorr
 */
@Service
@Profile("prod")
public class Crawler implements CrawlerInterface {

    @Override
    public Collection<News> crawl() {
        HashSet<News> news = new HashSet<>();
        try {
            String startURL = "http://www.nzz.ch/";
            Document doc = Jsoup.connect(startURL).get();
            Elements contents = doc.select("article"); // extract all articles out of src
            long counter = 1;
            for (Element content : contents) {//getting content for all article
                Elements articleLink = content.select("a.teaser__link");
                Element img = articleLink.select("img").first();
                String imageSrc = null;
                try {//try to clean image src
                    imageSrc = img.attr("data-srcset");
                    imageSrc = imageSrc.split(",")[0].split(" ")[0];
                } catch (Exception e) {
                }
                String title = articleLink.select("div.title__catchline").text();
                String undertitle = articleLink.select("div.title__name").text();
                String link = articleLink.select("[href]").attr("href");
                news.add(new News(counter, title, undertitle, link, imageSrc, "DE"));
                counter++;
            }
        } catch (Exception ex) {
            System.out.println("Website not parsed!!");
            return null;
        }
        return news;
    }
}
