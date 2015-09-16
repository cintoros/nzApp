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
    private GitHubService service;
    private RestAdapter restAdapter;
    private String url = "http://10.0.2.2:8080/";

    public NewsServiceImpl(NewsListener listener) {
        restAdapter = new RestAdapter.Builder()
                .setEndpoint(url)
                .build();
        service = restAdapter.create(GitHubService.class);
        this.listener = listener;
    }

    @Override
    public void getNewsByLanguage(Language language) {
        service.getNews(new Callback<News[]>() {
            @Override
            public void success(News[] news, Response response) {
                System.out.println("Response-Message: " + response);
                listener.setNews(news);
            }

            @Override
            public void failure(RetrofitError error) {
                System.out.println("Error-Message: " + error);
            }
        });
    }
}
