package fhnw.ch.nzapp.news.service;

import fhnw.ch.nzapp.news.model.Language;

/**
 * @author Elias Schorr
 * @since 16.09.2015
 */
public interface NewsService {

    void getNewsByLanguage(Language language);
}
