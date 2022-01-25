package com.example.coffeeapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.DisplayMetrics;
import android.util.LruCache;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.Volley;
import com.example.coffeeapp.application.CoffeeApplication;

public class ImageRequester {

    private static ImageRequester instance = null;
    private final Context context;
    private final RequestQueue requestQueue;
    private final ImageLoader imageLoader;
    private final int maxByteSize;

    ImageRequester(){
        context = CoffeeApplication.getAppContext();
        this.requestQueue = Volley.newRequestQueue(context);
        this.requestQueue.start();
        this.maxByteSize = getMaxByteSize();
        this.imageLoader = new ImageLoader(
                requestQueue,
                new ImageLoader.ImageCache() {
                    private final LruCache<String, Bitmap> lruCache = new LruCache<String, Bitmap>(maxByteSize){
                        @Override
                        protected int sizeOf(String url, Bitmap bitmap){
                            return bitmap.getByteCount();
                        }
                    };
                    @Override
                    public Bitmap getBitmap(String url) {
                        return lruCache.get(url);
                    }

                    @Override
                    public void putBitmap(String url, Bitmap bitmap) {
                        lruCache.put(url, bitmap);
                    }
                }
        );

    }

    public static ImageRequester getInstance(){
        if(instance == null){
            instance = new ImageRequester();
        }
        return instance;
    }

    public void setImageFromUrl(NetworkImageView image, String url){
        image.setImageUrl(url, imageLoader);
    }

    public int getMaxByteSize(){
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        final int screenByteSize = displayMetrics.widthPixels * displayMetrics.heightPixels * 4;
        return screenByteSize * 3;
    }
}
