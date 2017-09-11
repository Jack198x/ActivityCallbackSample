package cn.jack.activitycallback;


import android.app.Fragment;
import android.content.Intent;

/**
 * Created by Jack on 2017/9/11.
 */

public class ActivityCallbackFragment extends Fragment {

    private Intent intent;
    private int requestCode;
    private Callback callback;

    public ActivityCallbackFragment() {

    }

    public void setIntent(Intent intent) {
        this.intent = intent;
    }

    public void setRequestCode(int requestCode) {
        this.requestCode = requestCode;
    }

    public void setCallback(Callback callback) {
        this.callback = callback;
    }

    public void start() {
        startActivityForResult(intent, requestCode);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(callback!=null){
            callback.onActivityResult(requestCode, resultCode, data);
        }
    }
}
