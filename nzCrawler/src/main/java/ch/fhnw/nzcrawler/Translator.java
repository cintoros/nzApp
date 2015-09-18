package ch.fhnw.nzcrawler;

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
@Profile("prod")
public class Translator implements TranslatorInterface {

    private static final String ID = "nzzwebcrawlertranslator", SECRET_ID = "kssG2B8sxyy3VmlbABVLp4KLffH/FPauAKdPW1q5ivg=";

    @Override
    public String getTranslation(Language language, String text) {
        try {
            Translate.setClientId(ID);
            Translate.setClientSecret(SECRET_ID);
            String execute = Translate.execute(text, language);
            System.out.println(execute);
            return execute;
        } catch (Exception e) {
            System.out.println(e);
            System.err.println(e);
            return null;
        }
    }

}
