package com.baidu.apistore.sdk.laugh;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.baidu.apistore.sdk.ApiCallBack;
import com.baidu.apistore.sdk.ApiStoreSDK;
import com.baidu.apistore.sdk.R;
import com.baidu.apistore.sdk.lovebible.Data;
import com.baidu.apistore.sdk.network.Parameters;
import com.google.gson.Gson;

import org.jsoup.Jsoup;

import java.util.List;

public class LaughActivity extends AppCompatActivity {

    long startTime;
    EditText mTextView;

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            //双击退出
            long endTime = System.currentTimeMillis();
            if (endTime - startTime < 1000) {
                System.exit(0);
            } else {
                startTime = endTime;
            }
            return false;
        }
        return super.onKeyUp(keyCode, event);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
    }

    private void initUI() {
        mTextView = (EditText) findViewById(R.id.mTextView);
        apiTest();
    }

    private void apiTest() {
        String url = "http://route.showapi.com/341-1?maxResult=6&page=1&showapi_appid=15872&time=2016-04-14&showapi_sign=e70cb02184704473bcd17f2371f8d8ef";
        Parameters para = new Parameters();
        ApiStoreSDK.execute(url,
                ApiStoreSDK.GET,
                para,
                new ApiCallBack() {

                    @Override
                    public void onSuccess(int status, String responseString) {
                        Log.i("sdkdemo", "onSuccess" + responseString);

                        Root root = new Gson().fromJson(responseString, Root.class);
                        List<Contentlist> list = root.getShowapi_res_body().getContentlist();
                        String result = "";
                        for (int i = 0; i < list.size(); i++) {
                            result += list.get(i).getTitle() + "\n" + Html.fromHtml(list.get(i).getText()).toString() + "\n\n";
                        }
                        mTextView.setText(result);

                    }

                    @Override
                    public void onComplete() {
                        Log.i("sdkdemo", "onComplete");
                    }

                    @Override
                    public void onError(int status, String responseString, Exception e) {
                        Log.i("sdkdemo", "onError, status: " + status);
                        Log.i("sdkdemo", "errMsg: " + (e == null ? "" : e.getMessage()));
                        mTextView.setText(getStackTrace(e));
                    }

                });

    }

    String getStackTrace(Throwable e) {
        if (e == null) {
            return "";
        }
        StringBuilder str = new StringBuilder();
        str.append(e.getMessage()).append("\n");
        for (int i = 0; i < e.getStackTrace().length; i++) {
            str.append(e.getStackTrace()[i]).append("\n");
        }
        return str.toString();
    }
}
