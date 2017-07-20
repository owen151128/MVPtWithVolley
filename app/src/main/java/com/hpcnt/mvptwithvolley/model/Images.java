package com.hpcnt.mvptwithvolley.model;

import android.graphics.Bitmap;

/**
 * Created by 0wen151128 on 2017. 7. 20..
 */

public class Images {
    private Bitmap bitmap;
    private String Url;

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        this.Url = url;
    }
}
