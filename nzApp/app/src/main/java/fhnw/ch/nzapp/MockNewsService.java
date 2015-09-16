package fhnw.ch.nzapp;

import java.util.List;

/**
 * Created by eliasschorr on 16.09.2015.
 */
public class MockNewsService implements NewsService {
    @Override
    public News[]getNewsByLanguage(Language language) {
        News news[] = {new News("title", "undertitle", "link"), new News("title", "undertitel", "link")};
        return news;
    }
}
