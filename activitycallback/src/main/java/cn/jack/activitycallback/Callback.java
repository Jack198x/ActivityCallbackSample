package cn.jack.activitycallback;

import android.content.Intent;

/**
 * Created by Jack on 2017/9/11.
 */

public interface Callback {

    void onActivityResult(int requestCode, int resultCode, Intent data);
}
