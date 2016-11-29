package com.dronteam.adm.i_moby.scenarios.main;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;

import com.dronteam.adm.i_moby.R;
import com.dronteam.adm.i_moby.model.Item;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

/**
 * Created by adm on 14.11.2016.
 */
public class ItemPresenter {
    ItemView view;
    Item item;
    private Context context;
    private Bitmap loadedImage = null;
    final Target target = new Target(){
        @Override
        public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
            loadedImage = bitmap;
            view.setImage(loadedImage);
        }

        @Override
        public void onBitmapFailed(Drawable errorDrawable) {
        }

        @Override
        public void onPrepareLoad(Drawable placeHolderDrawable) {
        }
    };

    public ItemPresenter(Context context, Item item) {
        this.context = context;
        this.view = new ItemFragment(context);
        this.item = item;
        this.view.setEditListener(edit());
        Picasso.with(context).load(item.getThumb_photo()).into(target);
    }

    private View.OnClickListener edit() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        };
    }

    public void fill(){
        view.setText(item.getTitle(), item.description, item.price.text);
        if(loadedImage != null)
            view.setImage(loadedImage);
        else
            view.setImage(R.mipmap.ic_launcher);
    }

}
