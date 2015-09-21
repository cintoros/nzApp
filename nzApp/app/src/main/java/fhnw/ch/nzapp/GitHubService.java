package fhnw.ch.nzapp;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * @author Elias Schorr
 * @since 16.09.2015
 */
public interface GitHubService {

    @GET(AppSettings.All_TITLES)
    void getNews(Callback<News[]> values);

    @GET(AppSettings.TITLE_LANG + "DE")
    void getNewsDE(Callback<News[]> values);

    @GET(AppSettings.TITLE_LANG + "EN")
    void getNewsEN(Callback<News[]> values);

    @GET(AppSettings.TITLE_LANG + "FR")
    void getNewsFR(Callback<News[]> values);
}

