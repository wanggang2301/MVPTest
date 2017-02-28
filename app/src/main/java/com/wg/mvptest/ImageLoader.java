package com.wg.mvptest;

import android.content.Context;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * @author: Wangg
 * @Name：ImageLoader
 * @Description:
 * @Created on:2016/11/2  15:57.
 */

public class ImageLoader {

    public static void with(Context context, String imageUrl, ImageView imageView) {
        Picasso.with(context).load(imageUrl).into(imageView);


    }

}
