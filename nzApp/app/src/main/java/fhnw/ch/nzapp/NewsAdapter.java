package fhnw.ch.nzapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * @author Elias Schorr
 * @since 16.09.2015
 */
public class NewsAdapter extends ArrayAdapter<News> implements NewsListener {

    public NewsAdapter(Context context, News[] resource) {
        super(context, R.layout.row_layout_2, resource);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        View row = layoutInflater.inflate(R.layout.row_layout_2, parent, false);
        News news = getItem(position);
        TextView titleView = (TextView) row.findViewById(R.id.TitleView);
        titleView.setText(news.getTitle());
        TextView underTitleView = (TextView) row.findViewById(R.id.UnderTitleView);
        underTitleView.setText(news.getUndertitle());
        String imageLink = news.getImageLink();
        new DownloadImageTask(new ImageLoadListener(row.findViewById(R.id.ImageContainer))).execute(imageLink);
        return row;
    }

    @Override
    public void setNews(News[] news) {
        clear();
        addAll(news);
    }
}
