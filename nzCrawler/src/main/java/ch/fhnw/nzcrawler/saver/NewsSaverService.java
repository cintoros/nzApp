package ch.fhnw.nzcrawler.saver;

import ch.fhnw.nzcrawler.model.News;
import ch.fhnw.nzcrawler.repos.NewsLangRepo;
import ch.fhnw.nzcrawler.repos.NewsLinkRepo;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Elias Schorr
 * @since 18.09.2015
 */
public abstract class NewsSaverService {

    @Autowired
    protected NewsLangRepo newsLangRepo;
    @Autowired
    protected NewsLinkRepo newsLinkRepo;

    protected void clearRepos() {
        newsLangRepo.deleteAll();
        newsLinkRepo.deleteAll();
    }

    abstract public void save(Collection<News> news);

}
