package com.esing.cybercontroller.ui.activities;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.esing.cybercontroller.R;
import com.esing.cybercontroller.utils.DeviceUtil;


public class BrowserActivity extends Activity {

    private WebView wv_browser;


    public static void startMe(Activity activity, boolean directUnlock) {
        Intent intent = new Intent(activity, BrowserActivity.class);
        intent.putExtra("directUnlock", directUnlock);
        activity.startActivity(intent);
        DeviceUtil.acquireWakeLock(activity, 1000);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monitor);

        wv_browser = findViewById(R.id.wv_browser);

        //设置 WebView 属性，能够执行 Javascript 脚本
        wv_browser.getSettings().setJavaScriptEnabled(true);

        //加载需要显示的网页


        WebView.setWebContentsDebuggingEnabled(true);
        wv_browser.setLayerType(View.LAYER_TYPE_SOFTWARE, null);//关掉硬件加速
        wv_browser.setWebViewClient(new WebViewClient());
        //加载需要显示的网页
        //wv_browser.loadUrl("https://www.baidu.com");
        wv_browser.loadUrl("http://192.168.31.234:8888/");
        wv_browser.setBackgroundColor(Color.BLACK);
        wv_browser.setInitialScale(75);
    }

}
