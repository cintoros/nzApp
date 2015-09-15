package ch.fhnw.nzcrawler;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Elias Schorr
 */
@RestController
public class MockNewsController {

    @Autowired
    private NewsRepo newsRepo;

    @RequestMapping("/titles")
    public List<News> getTitles() {
        return newsRepo.findAll();
    }

}
