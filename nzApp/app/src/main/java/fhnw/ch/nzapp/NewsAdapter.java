package fhnw.ch.nzapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by eliasschorr on 16.09.2015.
 */
public class NewsAdapter extends ArrayAdapter<News> implements NewsListener {

    public NewsAdapter(Context context, News[] resource) {
        super(context, R.layout.row_layout_2, resource);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        View view = layoutInflater.inflate(R.layout.row_layout_2, parent, false);
        News item = getItem(position);
        TextView view1 = (TextView) view.findViewById(R.id.TitleView);
        view1.setText(item.getTitle());
        TextView view2 = (TextView) view.findViewById(R.id.UnderTitleView);
        view2.setText(item.getUndertitle());
        String imageLink = item.getImageLink();
        Bitmap bitmapFromURL = getBitmapFromURL(imageLink);
        if (bitmapFromURL != null) {
            ImageView view3 = (ImageView) view.findViewById(R.id.ImageView);
            view3.setImageBitmap(bitmapFromURL);
        }
        return view;
    }

    private Bitmap getBitmapFromURL(String src) {
        try {
            Log.e("src", src);
            URL url = new URL(src);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            Bitmap myBitmap = BitmapFactory.decodeStream(input);
            Log.e("Bitmap", "returned");
            return myBitmap;
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("Exception", e.getMessage());
            return null;
        }
    }

    @Override
    public void setNews(News[] news) {
        clear();
        addAll(news);
    }
}
