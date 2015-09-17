package fhnw.ch.nzapp;

import java.util.List;

/**
 * Created by eliasschorr on 16.09.2015.
 */
public class MockNewsService implements NewsService {
    private final NewsListener listener;

    public MockNewsService(NewsListener listener) {
        this.listener = listener;
    }

    @Override
    public void getNewsByLanguage(Language language) {
        News news[] = {new News("title_1", "undertitle_1", "link", "link"), new News("title_1", "undertitel_1", "link", "link")};
        listener.setNews(news);
    }
}
