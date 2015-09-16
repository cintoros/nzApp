package ch.fhnw.nzcrawler;

import java.util.Collection;
import java.util.List;
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
    private NewsRepo newsRepo;

    @RequestMapping("/alltitles")
    public List<News> getTitles() {
        return newsRepo.findAll();
    }

    @RequestMapping("/titles")
    public Collection<News> getTitlesByLanguage(@RequestParam(value = "language") String language) {
        System.out.println("ByLan: " + language);
        Collection<News> findByLanguage = newsRepo.findByLanguage(language);
        for (News findByLanguage1 : findByLanguage) {
            System.out.println(findByLanguage.toString());
        }
        return findByLanguage;
    }

}
