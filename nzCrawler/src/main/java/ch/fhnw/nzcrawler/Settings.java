package ch.fhnw.nzcrawler;

/**
 *
 * @author Elias Schorr
 */
public class Settings {

    public static final String HOMEPAGE = "http://www.nzz.ch/";
    public static final Boolean MULTI_LANG = Boolean.FALSE;
    public static final String PROD = "prod", DEV = "dev";
    public static final String ID = "nzzwebcrawlertranslator", SECRET_ID = "kssG2B8sxyy3VmlbABVLp4KLffH/FPauAKdPW1q5ivg=";
    public static final String ADMIN = "admin", PASSWORD = "passwort";
    public static final Boolean AUTO_CRAWL = Boolean.TRUE;
    /**
     * Duration between crawling of AutoCrawler in miliseconds
     */
    public static final Long DURATION = (long) 3600000;//3600000=1 hour
}
