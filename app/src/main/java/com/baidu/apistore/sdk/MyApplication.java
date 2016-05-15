package com.baidu.apistore.sdk;

import android.app.Application;

// 请在AndroidManifest.xml中application标签下android:name中指定该类
public class MyApplication extends Application {
    
    @Override
    public void onCreate() {
        super.onCreate();
        ApiStoreSDK.init(this, "e84c13f5bebb54dd7565314f81a83a8a");
    }
}
