package com.mlanka.authfun;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.mlanka.authfun.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    String toast = "Howdy!";
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.webview.addJavascriptInterface(new JavaScriptInterface(this), "Android");
        binding.webview.getSettings().setJavaScriptEnabled(true);
        binding.webview.loadUrl("file:///android_asset/index.html");
        binding.webview.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                Log.d(TAG, "onPageFinished: url" + url);
                binding.webview.loadUrl("javascript:init('" + toast + "')");
            }
        });
    }
}
