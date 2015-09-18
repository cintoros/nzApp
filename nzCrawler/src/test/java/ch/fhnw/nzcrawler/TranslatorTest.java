package ch.fhnw.nzcrawler;

import com.memetix.mst.language.Language;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Elias Schorr
 */
public class TranslatorTest {

    private static Translator instance;

    @BeforeClass
    public static void setUpClass() {
        instance = new Translator();
    }

    /**
     * Test of getTranslation method, of class Translator.
     */
    @Test
    public void testGetTranslation() {
        Language language = Language.ENGLISH;
        String text = "Hallo Welt";
        String expResult = "Hello world";
        String result = instance.getTranslation(language, text);
        assertEquals("german to english", expResult, result);
    }

}
