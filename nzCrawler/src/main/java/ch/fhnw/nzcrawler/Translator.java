package ch.fhnw.nzcrawler;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 *
 * @author Elias Schorr
 * @since 18.09.2015
 */
@Service
@Profile("prod")
public class Translator implements TranslatorInterface {

    @Override
    public String getTranslation(Language language, String text) {
        try {
            //TODO translation of text
            return null;
        } catch (Exception e) {
            return null;
        }
    }

}
