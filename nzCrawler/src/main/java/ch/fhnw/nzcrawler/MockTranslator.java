package ch.fhnw.nzcrawler;

import com.memetix.mst.language.Language;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 *
 * @author Elias Schorr
 * @since 18.09.2015
 */
@Service
@Profile("dev")
public class MockTranslator implements TranslatorInterface {

    @Override
    public String getTranslation(Language language, String text) {
        return "translated" + text;
    }

}
