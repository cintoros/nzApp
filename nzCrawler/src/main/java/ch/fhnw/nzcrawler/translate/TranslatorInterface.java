package ch.fhnw.nzcrawler.translate;

import com.memetix.mst.language.Language;

/**
 *
 * @author Elias Schorr
 * @since 18.09.2015
 */
public interface TranslatorInterface {

    public String getTranslation(Language language, String text);
}
