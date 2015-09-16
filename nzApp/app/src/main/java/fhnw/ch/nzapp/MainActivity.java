package fhnw.ch.nzapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Elias Schorr <elias.schorr@fhnw.ch>
 */
public class MainActivity extends AppCompatActivity implements NewsListener {
    private NewsService newsService = new NewsServiceImpl(this);
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
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(link));
                startActivity(browserIntent);
            }
        });
        News news[] = {new News("title", "undertitle", "link"), new News("title", "undertitel", "link")};
        final NewsAdapter adapter = new NewsAdapter(this, news);
        view.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            newsService.getNewsByLanguage(Language.DE);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void setNews(News[] news) {
        ListView view = (ListView) findViewById(R.id.ListView);
        adapter = new NewsAdapter(this, news);
        view.setAdapter(adapter);
    }
}
