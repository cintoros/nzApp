package ch.fhnw.nzcrawler.saver;

import ch.fhnw.nzcrawler.Settings;
import ch.fhnw.nzcrawler.model.News;
import ch.fhnw.nzcrawler.model.NewsLang;
import ch.fhnw.nzcrawler.model.NewsLink;
import ch.fhnw.nzcrawler.translate.Translator;
import com.memetix.mst.language.Language;
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
            newsLinkRepo.save(new NewsLink(aNew.getNewsId(), aNew.getLink(), aNew.getImageLink()));
            newsLangRepo.save(new NewsLang(aNew.getNewsId(), aNew.getTitle(), aNew.getUndertitle(), aNew.getLanguage()));//saving as german
            if (Settings.MULTI_LANG) {
                String title = aNew.getTitle();
                String undertitle = aNew.getUndertitle();
                Translator translator = new Translator();
                String titleEN = translator.getTranslation(Language.ENGLISH, title);
                String undertitleEN = translator.getTranslation(Language.ENGLISH, undertitle);
                String titleFR = translator.getTranslation(Language.FRENCH, title);
                String undertitleFR = translator.getTranslation(Language.FRENCH, undertitle);
                newsLangRepo.save(new NewsLang(aNew.getNewsId(), titleEN, undertitleEN, "EN"));
                newsLangRepo.save(new NewsLang(aNew.getNewsId(), titleEN, undertitleFR, "FR"));
            }
        }
    }
}
