package fhnw.ch.nzapp;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by eliasschorr on 16.09.2015.
 */
public interface GitHubService {

    @GET("/alltitles")
    void getNews(Callback<News[]> values);
}
