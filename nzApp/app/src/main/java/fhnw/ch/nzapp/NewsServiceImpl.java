package fhnw.ch.nzapp;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by eliasschorr on 16.09.2015.
 */
public class NewsServiceImpl implements NewsService {
    private final NewsListener listener;
    private final GitHubService service;
    private final RestAdapter restAdapter;

    public NewsServiceImpl(NewsListener listener) {
        restAdapter = new RestAdapter.Builder()
                .setEndpoint(AppSettings.SERVICE_URL)
                .build();
        service = restAdapter.create(GitHubService.class);
        this.listener = listener;
    }

    @Override
    public void getNewsByLanguage(Language language) {
        Callback<News[]> newsCallback = new Callback<News[]>() {
            @Override
            public void success(News[] news, Response response) {
                System.out.println("Response-Message: " + response);
                listener.setNews(news);
            }

            @Override
            public void failure(RetrofitError error) {
                System.out.println("Error-Message: " + error);
            }
        };
        switch (language) {
            case DE: {
                service.getNewsDE(newsCallback);
                break;
            }
            case EN: {
                service.getNewsEN(newsCallback);
                break;
            }
            case FR: {
                service.getNewsFR(newsCallback);
                break;
            }
            default: {
                service.getNews(newsCallback);
                break;
            }
        }
    }
}
