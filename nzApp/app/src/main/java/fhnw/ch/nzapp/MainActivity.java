package fhnw.ch.nzapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import fhnw.ch.nzapp.news.model.Language;
import fhnw.ch.nzapp.news.model.News;
import fhnw.ch.nzapp.news.service.MockNewsService;
import fhnw.ch.nzapp.news.service.NewsListener;
import fhnw.ch.nzapp.news.service.NewsService;
import fhnw.ch.nzapp.news.service.NewsServiceImpl;

/**
 * @author Elias Schorr
 */
public class MainActivity extends AppCompatActivity implements NewsListener {
    private final NewsService newsService = new NewsServiceImpl(this);
    private NewsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView view = (ListView) findViewById(R.id.ListView);
        view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String link = adapter.getItem(position).getLink();
                if (link != null) {
                    if (!link.startsWith("https://") && !link.startsWith("http://")) {
                        link = "http://" + link;
                    }
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.EMPTY, getApplicationContext(), WebBrowser.class);
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(link));
                    startActivity(browserIntent);
                }
            }
        });
        // fills the View with Mock-Items
        new MockNewsService(this).getNewsByLanguage(Language.DE);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.english: {
                newsService.getNewsByLanguage(Language.EN);
                break;
            }
            case R.id.french: {
                newsService.getNewsByLanguage(Language.FR);
                break;
            }
            case R.id.german: {
                newsService.getNewsByLanguage(Language.DE);
                break;
            }
            default:
                return false;
        }
        Toast.makeText(getApplicationContext(), "loading...", Toast.LENGTH_SHORT).show();
        return true;
    }

    @Override
    public void setNews(News[] news) {
        ListView view = (ListView) findViewById(R.id.ListView);
        adapter = new NewsAdapter(this, news);
        view.setAdapter(adapter);
        Toast.makeText(getApplicationContext(), "news received ", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFail() {
        Toast.makeText(getApplicationContext(), "failed to load news ", Toast.LENGTH_SHORT).show();
    }
}
