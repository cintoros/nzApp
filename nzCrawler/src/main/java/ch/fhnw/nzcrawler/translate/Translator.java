package ch.fhnw.nzcrawler.translate;

import ch.fhnw.nzcrawler.Settings;
import com.memetix.mst.language.Language;
import com.memetix.mst.translate.Translate;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 *
 * @author Elias Schorr
 * @since 18.09.2015
 */
@Service
@Profile(Settings.PROD)
public class Translator implements TranslatorInterface {

    @Override
    public String getTranslation(Language language, String text) {
        try {
            Translate.setClientId(Settings.ID);
            Translate.setClientSecret(Settings.SECRET_ID);
            String execute = Translate.execute(text, language);
            System.out.println(execute);
            return execute;
        } catch (Exception e) {
            return null;
        }
    }

}
