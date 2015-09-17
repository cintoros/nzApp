package ch.fhnw.nzcrawler;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
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
    public void crawl(NewsRepo newsRepo) {
        try {
            //both urls work
            String startURL = "http://www.nzz.ch/newsticker/";
//            String startURL = "http://www.nzz.ch/";
            URL url = new URL(startURL);
            URLConnection conn = url.openConnection();
            conn.setRequestProperty("User-Agent", "TagCloudWebCrawler/0.1 Mozilla/5.0");
            BufferedInputStream pageInputStream = new BufferedInputStream(conn.getInputStream());
            Document doc = Jsoup.parse(pageInputStream, null, startURL);
            // extract all articles out of src
            Elements contents = doc.select("article");
            for (Element content : contents) {//getting content for all articles
                Elements articleLink = content.select("a.teaser__link");
                String title = articleLink.select("div.title__catchline").text();
                String undertitle = articleLink.select("div.title__name").text();
                String link = articleLink.select("[href]").attr("href");
                System.out.println("Title:");
                System.out.println(title);
                System.out.println("undertitle:");
                System.out.println(undertitle);
                System.out.println("Link:");
                System.out.println(link);
                newsRepo.save(new News(title, undertitle, link, "DE"));
            }
        } catch (MalformedURLException ex) {
            System.out.println("Website not found!!");
        } catch (IOException ex) {
            System.out.println("Website not parsed!!");
        }

    }
}
