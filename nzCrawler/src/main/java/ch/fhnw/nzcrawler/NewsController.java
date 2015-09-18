package ch.fhnw.nzcrawler;

import ch.fhnw.nzcrawler.repos.NewsLinkRepo;
import ch.fhnw.nzcrawler.repos.NewsLangRepo;
import ch.fhnw.nzcrawler.model.News;
import ch.fhnw.nzcrawler.model.NewsLink;
import ch.fhnw.nzcrawler.model.NewsLang;
import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Elias Schorr
 */
@RestController
public class NewsController {

    @Autowired
    private NewsLangRepo langRepo;
    @Autowired
    private NewsLinkRepo linkRepo;

    @RequestMapping("/alltitles")
    public Collection<News> getTitles() {
        return getNews("DE");
    }

    @RequestMapping("/titles")
    public Collection<News> getTitlesByLanguage(@RequestParam(value = "language") String language) {
        System.out.println("ByLan: " + language);
        return getNews(language);
    }

    private Collection<News> getNews(String language) {
        HashSet<News> news = new HashSet<>();
        Collection<NewsLang> findByLanguage = langRepo.findByLanguage(language);
        for (NewsLang findByLanguage1 : findByLanguage) {
            Optional<NewsLink> findById = linkRepo.findByNewsId(findByLanguage1.getId());
            if (findById.isPresent()) {
                news.add(new News(findByLanguage1, findById.get()));
            }
        }
        return news;
    }

}
