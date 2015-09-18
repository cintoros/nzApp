package ch.fhnw.nzcrawler.saver;

import ch.fhnw.nzcrawler.model.News;
import ch.fhnw.nzcrawler.model.NewsLang;
import ch.fhnw.nzcrawler.model.NewsLink;
import java.util.Collection;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 *
 * @author Elias Schorr
 * @since 18.09.2015
 */
@Service
@Profile("prod")
public class NewsSaver extends NewsSaverService {

    @Override
    public void save(Collection<News> news) {
        clearRepos();
        for (News aNew : news) {
            newsLinkRepo.save(new NewsLink(aNew.getId(), aNew.getLink(), aNew.getImageLink()));
            newsLangRepo.save(new NewsLang(aNew.getId(), aNew.getTitle(), aNew.getUndertitle(), aNew.getLanguage()));//saving as german
            //TODO save it under different languages with Translator
        }
    }
}
