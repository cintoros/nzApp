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
            String startURL = "http://www.nzz.ch/";
            Document doc = Jsoup.connect(startURL).get();
            Elements contents = doc.select("article"); // extract all articles out of src
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
                System.out.println("Title:");
                System.out.println(title);
                System.out.println("undertitle:");
                System.out.println(undertitle);
                System.out.println("Link:");
                System.out.println(link);
                System.out.println("Image:");
                System.out.println(imageSrc);
                newsRepo.save(new News(title, undertitle, link, imageSrc, "DE"));
            }
        } catch (MalformedURLException ex) {
            System.out.println("Website not found!!");
        } catch (IOException ex) {
            System.out.println("Website not parsed!!");
        }

    }
}
