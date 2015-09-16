package fhnw.ch.nzapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by eliasschorr on 16.09.2015.
 */
public class NewsAdapter extends ArrayAdapter<News> {

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
        return view;
    }
}
