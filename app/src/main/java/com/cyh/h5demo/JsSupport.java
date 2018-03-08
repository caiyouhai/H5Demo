package com.cyh.h5demo;

import android.content.Context;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

/**
 * @author youhai.cai
 *         create by 2018/3/7 15:39.
 */

public class JsSupport {
    private Context mContext;
    private String json;
    public JsSupport(Context context) {
        mContext = context;
    }

    public Context getmContext() {
        return mContext;
    }

    public void setmContext(Context mContext) {
        this.mContext = mContext;
    }

    //@JavascriptInterface这个注解说明,该方法可以在js中调用.
    @JavascriptInterface
    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }

    @JavascriptInterface
    public void showToast(String str) {
        Toast.makeText(mContext, str, Toast.LENGTH_SHORT).show();
    }

}
