package fhnw.ch.nzapp.news.service;

import fhnw.ch.nzapp.news.model.Language;
import fhnw.ch.nzapp.news.model.News;

/**
 * @author Elias Schorr
 * @since 16.09.2015
 */
public class MockNewsService implements NewsService {
    private final NewsListener listener;

    public MockNewsService(NewsListener listener) {
        this.listener = listener;
    }

    @Override
    public void getNewsByLanguage(Language language) {
        News news[] = {new News("Start", "Um die News abzurufen klicken Sie auf das Menu und wählen Sie Deutsch", null, null),
                new News("Start", "To retrieve the news, click the menu and select English", null, null),
                new News("Démarrer", "Pour récupérer les nouvelles, cliquez sur le menu et sélectionnez français", null, null)};
        listener.setNews(news);
    }
}
