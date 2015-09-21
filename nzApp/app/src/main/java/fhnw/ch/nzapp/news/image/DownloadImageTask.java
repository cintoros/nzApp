package fhnw.ch.nzapp.news.image;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import java.io.InputStream;

/**
 * @author  Elias Schorr
 * @since 18.09.2015
 */
public class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
    ImageLoadListener listener;

    public DownloadImageTask(ImageLoadListener listener) {
        this.listener = listener;
    }

    protected Bitmap doInBackground(String... urls) {
        String urldisplay = urls[0];
        Bitmap mIcon11 = null;
        try {
            InputStream in = new java.net.URL(urldisplay).openStream();
            mIcon11 = BitmapFactory.decodeStream(in);
        } catch (Exception e) {
        }
        return mIcon11;
    }

    protected void onPostExecute(Bitmap result) {
        if (result != null) {
            listener.onSuccess(result);
        } else {
            listener.onFailure("FAILED TO LOAD IMAGE");
        }
    }
}