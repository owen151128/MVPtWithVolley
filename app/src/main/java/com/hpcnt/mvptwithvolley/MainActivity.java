package com.hpcnt.mvptwithvolley;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.Volley;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    private static final String targetUrl = "https://s-media-cache-ak0.pinimg.com/originals/0a/8b/51/0a8b51c7f81414365bdfa9ca3c569778.jpg";
    private static final String TAG = "MAIN";
    @BindView(R.id.imageView)
    ImageView imageView;
    private RequestQueue queue;
    private ImageRequest request;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        queue = Volley.newRequestQueue(this);
        request = new ImageRequest(targetUrl, new ResponseListener(), 0, 0, null, Bitmap.Config.RGB_565, new ResponseErrorListener());
        request.setTag(TAG);
        queue.add(request);
    }

    class ResponseListener implements Response.Listener<Bitmap> {
        @Override
        public void onResponse(Bitmap response) {
            Log.e("DEBUG", "Result : " + response);
            imageView.setImageBitmap(response);
        }
    }

    class ResponseErrorListener implements Response.ErrorListener {
        @Override
        public void onErrorResponse(VolleyError error) {
            Log.e("DEBUG", error.toString());
        }
    }

    @Override
    protected void onStop() {
        super.onStop();

        if (queue != null)
            queue.cancelAll(TAG);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        System.exit(0);
    }
}
