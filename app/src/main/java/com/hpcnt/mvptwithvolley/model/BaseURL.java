package com.hpcnt.mvptwithvolley.model;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by 0wen151128 on 2017. 7. 20..
 */

public class BaseURL {
    private String url;
    private String host;
    private String directory;

    public void setUrl(String url) {
        try {
            this.url = url;
            URL instance = new URL(url);
            host = url.substring(0, url.indexOf(":")) + "://" + instance.getHost();
            directory = instance.getFile();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public String getUrl() {
        return url;
    }

    public String getHost() {
        return host;
    }

    public String getDirectory() {
        return directory;
    }
}
