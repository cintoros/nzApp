package ch.fhnw.nzcrawler.translate;

import ch.fhnw.nzcrawler.Settings;
import com.memetix.mst.language.Language;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 *
 * @author Elias Schorr
 * @since 18.09.2015
 */
@Service
@Profile(Settings.DEV)
public class MockTranslator implements TranslatorInterface {

    @Override
    public String getTranslation(Language language, String text) {
        return "translated: " + text;
    }

}
