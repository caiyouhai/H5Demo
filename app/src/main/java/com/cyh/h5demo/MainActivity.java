package com.cyh.h5demo;

import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.google.gson.Gson;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private final String TAG=this.getClass().getSimpleName();

    private WebView mWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.js_invoke_java).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //添加Json数据
                addJson();
            }
        });
        findViewById(R.id.java_invoke_js).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                mWebView.reload();
                SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss", Locale.getDefault());
                String name=sdf.format(new Date());
                mWebView.loadUrl("javascript:javaCallJs("+"'"+name+"'"+")");
            }
        });




        mWebView = (WebView) findViewById(R.id.main_web_view);
//解决点击链接跳转浏览器问题
        mWebView.setWebViewClient(new WebViewClient());
//js支持
        WebSettings settings = mWebView.getSettings();
        settings.setJavaScriptEnabled(true);
//允许访问assets目录
        settings.setAllowFileAccess(true);
//设置WebView排版算法, 实现单列显示, 不允许横向移动
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
//assets文件路径
        String path = "file:///android_asset/index.html";

//加载Html页面
        mWebView.loadUrl(path);
    }

    private void addJson() {
        JsSupport jsSupport = new JsSupport(this);
        List<FriendsZone> zones = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            zones.add(new FriendsZone("标题" + i, "images/icon.png", "这里是Html测试数据, 这里是Html测试数据, 这里是Html测试数据" + i));
        }
        Gson gson = new Gson();
        String json = gson.toJson(zones);
        Log.i(TAG, "addJson: json => " + json);
        jsSupport.setJson(json);
        //添加js交互接口, 并指明js中对象的调用名称
        mWebView.addJavascriptInterface(jsSupport, "weichat");
        mWebView.reload();  //刷新
    }

    @Override
    public void onBackPressed() {
        if (mWebView.canGoBack()) {
            mWebView.goBack();
        } else {
            super.onBackPressed();
        }
    }


}
