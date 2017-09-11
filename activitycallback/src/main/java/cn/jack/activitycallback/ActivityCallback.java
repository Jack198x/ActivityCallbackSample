package cn.jack.activitycallback;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;

/**
 * Created by Jack on 2017/9/11.
 */

public class ActivityCallback {

    private static final String TAG = "ActivityCallbackFragment";
    private Activity activity;
    private Intent intent;
    private int requestCode;
    private Callback callback;
    private ActivityCallbackFragment fragment;

    private ActivityCallback(Activity activity) {
        this.activity = activity;
        fragment = new ActivityCallbackFragment();
        FragmentManager fragmentManager = activity.getFragmentManager();
        fragmentManager
                .beginTransaction()
                .add(fragment, TAG)
                .commitAllowingStateLoss();
        fragmentManager.executePendingTransactions();
    }

    public static ActivityCallback with(Activity activity) {
        return new ActivityCallback(activity);
    }

    public ActivityCallback intent(Intent intent) {
        this.intent = intent;
        return this;
    }

    public ActivityCallback callback(Callback callback) {
        this.callback = callback;
        return this;
    }

    public ActivityCallback requestCode(int requestCode) {
        this.requestCode = requestCode;
        return this;
    }

    public void start() {
        fragment.setCallback(callback);
        fragment.setRequestCode(requestCode);
        fragment.setIntent(intent);
        fragment.start();
    }
}
