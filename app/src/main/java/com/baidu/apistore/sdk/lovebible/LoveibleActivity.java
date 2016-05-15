package com.baidu.apistore.sdk.lovebible;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.baidu.apistore.sdk.ApiCallBack;
import com.baidu.apistore.sdk.ApiStoreSDK;
import com.baidu.apistore.sdk.R;
import com.baidu.apistore.sdk.network.Parameters;
import com.baidu.apistore.sdk.weather.Basic;
import com.baidu.apistore.sdk.weather.Now;
import com.baidu.apistore.sdk.weather.Suggestion;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/*
 * 测试前请在MyApplication.java中配置您的appkey
 */
public class LoveibleActivity extends AppCompatActivity {

    TextView mTextView;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
    }

    private void initUI() {
        mTextView = (TextView) findViewById(R.id.mTextView);
        apiTest();
    }

    private void apiTest() {

        Parameters para = new Parameters();
        ApiStoreSDK.execute("http://apis.baidu.com/gushi/lovebible/say1",
                ApiStoreSDK.GET,
                para,
                new ApiCallBack() {

                    @Override
                    public void onSuccess(int status, String responseString) {
                        Log.i("sdkdemo", "onSuccess" + responseString);
                        Root root = new Gson().fromJson(responseString, Root.class);
                        List<Data> list = root.getData();
                        String result = "";
                        for (int i = 0; i < list.size(); i++) {
                            result += list.get(i).getTitle() + "\n\n";
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
