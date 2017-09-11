package cn.jack.activitycallbacksample;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import cn.jack.activitycallback.ActivityCallback;
import cn.jack.activitycallback.Callback;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Intent intent = new Intent();
        intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);

        findViewById(R.id.text).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityCallback.with(MainActivity.this)
                        .callback(new Callback() {
                            @Override
                            public void onActivityResult(int requestCode, int resultCode, Intent data) {
                                Log.e("requestCode",requestCode+"");
                                Log.e("resultCode",resultCode+"");
                            }
                        }).intent(intent)
                        .requestCode(100)
                        .start();
            }
        });

    }
}
