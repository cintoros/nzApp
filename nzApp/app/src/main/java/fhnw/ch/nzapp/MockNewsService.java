package fhnw.ch.nzapp;

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
        News news[] = {new News("title_1", "undertitle_1", null, null), new News("title_1", "undertitel_1", null, null)};
        listener.setNews(news);
    }
}
