package fhnw.ch.nzapp;

import java.util.List;

/**
 * Created by eliasschorr on 16.09.2015.
 */
public interface NewsService {

    News[] getNewsByLanguage(Language language);
}
