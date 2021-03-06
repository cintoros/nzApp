package fhnw.ch.nzapp.news.image;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;

import fhnw.ch.nzapp.R;

/**
 * @author Elias Schorr
 * @since 18.09.2015.
 */
public class ImageLoadListener {
    private final View parent;

    public ImageLoadListener(View parent) {
        this.parent = parent;
    }

    public void onSuccess(Bitmap result) {
        try {
            ImageView image = (ImageView) parent.findViewById(R.id.ImageView);
            image.setImageBitmap(result);
        } catch (Exception e) {
            deleteImage();
        }
        deleteProgress();
    }

    public void onFailure(String message) {
        System.out.println(message);
        deleteImage();
        deleteProgress();
    }

    private void deleteImage() {
        try {
            View viewById = parent.findViewById(R.id.ImageView);
            viewById.setVisibility(View.GONE);
        } catch (Exception e) {
        }

    }

    private void deleteProgress() {
        try {
            View viewById = parent.findViewById(R.id.progressBar);
            viewById.setVisibility(View.GONE);
        } catch (Exception e) {
        }
    }
}
