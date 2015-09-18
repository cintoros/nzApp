package fhnw.ch.nzapp;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by eliasschorr on 16.09.2015.
 */
public interface GitHubService {

    @GET("/alltitles")
    void getNews(Callback<News[]> values);

    @GET("/titles?language=DE")
    void getNewsDE(Callback<News[]> values);

    @GET("/titles?language=EN")
    void getNewsEN(Callback<News[]> values);

    @GET("/titles?language=FR")
    void getNewsFR(Callback<News[]> values);
}

