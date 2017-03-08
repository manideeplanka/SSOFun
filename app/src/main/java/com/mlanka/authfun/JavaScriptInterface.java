package com.mlanka.authfun;

import android.content.Context;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

/**
 * Created by mlanka on 8/3/17.
 */
public class JavaScriptInterface {
    Context mContext;
    private static final String TAG = "JavaScriptInterface";

    JavaScriptInterface(Context context) {
        mContext = context;
    }

    @JavascriptInterface
    public void showToast(String toast) {
        Log.d(TAG, "showToast: " );
        Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show();
    }

}
