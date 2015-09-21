package fhnw.ch.nzapp.news.service;

import fhnw.ch.nzapp.news.model.News;

/**
 * @author Elias Schorr
 * @since 16.09.2015
 */
public interface NewsListener {

    void setNews(News[] news);
    void onFail();
}
