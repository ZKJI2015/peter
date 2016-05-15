package com.baidu.apistore.sdk.weather;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.baidu.apistore.sdk.ApiCallBack;
import com.baidu.apistore.sdk.ApiStoreSDK;
import com.baidu.apistore.sdk.R;
import com.baidu.apistore.sdk.network.Parameters;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;

/*
 * 测试前请在MyApplication.java中配置您的appkey
 */
public class MainActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener {

    EditText mTextView;
    String city = "zhengzhou";

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
        final TabLayout tabLayout = (TabLayout) findViewById(R.id.tablayout);
        tabLayout.addTab(tabLayout.newTab().setText("zhengzhou"));
        tabLayout.addTab(tabLayout.newTab().setText("shanghai"));
        tabLayout.addTab(tabLayout.newTab().setText("dancheng"));
        tabLayout.setOnTabSelectedListener(this);

        mTextView = (EditText) findViewById(R.id.mTextView);
        apiTest();
    }

    private void apiTest() {
        Parameters para = new Parameters();
        para.put("city", city);
        ApiStoreSDK.execute("http://apis.baidu.com/heweather/weather/free",
                ApiStoreSDK.GET,
                para,
                new ApiCallBack() {

                    @Override
                    public void onSuccess(int status, String responseString) {
                        Log.i("sdkdemo", "onSuccess" + responseString);
                        try {
                            JSONArray jsonArray = new JSONObject(responseString).getJSONArray("HeWeather data service 3.0");
                            String basicStr = jsonArray.getJSONObject(0).getJSONObject("basic").toString();
                            Basic basic = new Gson().fromJson(basicStr, Basic.class);
                            String nowStr = jsonArray.getJSONObject(0).getJSONObject("now").toString();
                            Now now = new Gson().fromJson(nowStr, Now.class);

//                            String hourly_forecastStr = jsonArray.getJSONObject(0).getJSONObject("hourly_forecast").toString();
//                            List<Hourly_forecast> hourly_forecast = new Gson().fromJson(hourly_forecastStr, new TypeToken<List<Hourly_forecast>>() {
//                            }.getType());
//                            for (int i = 0; i < hourly_forecast.size(); i++) {
//                                hourly_forecastStr += hourly_forecast.get(i).getDate() + ", " + hourly_forecast.get(i).getWind().getDir() + ", " + hourly_forecast.get(i).getWind().getSc() + "\n";
//                            }


                            String suggestionStr = jsonArray.getJSONObject(0).getJSONObject("suggestion").toString();
                            Suggestion suggestion = new Gson().fromJson(suggestionStr, Suggestion.class);


                            String str = basic.getCity() + ", " + now.getTmp() + "度, " + now.getCond().getTxt() + ", " + now.getWind().getDir() + now.getWind().getSc() + "级\n\n" + suggestion.getComf().getTxt() + "\n\n" + suggestion.getDrsg().getTxt() + "\n\n" + suggestion.getSport().getTxt() + "\n\n" + suggestion.getUv().getTxt() + "\n\n" + suggestion.getTrav().getTxt();

                            mTextView.setText(str);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }

                    @Override
                    public void onComplete() {
                        Log.i("sdkdemo", "onComplete");
                    }

                    @Override
                    public void onError(int status, String responseString, Exception e) {
                        Log.i("sdkdemo", "onError, status: " + status);
                        Log.i("sdkdemo", "errMsg: " + (e == null ? "" : e.getMessage()));
                    }

                });

    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        if (tab != null && tab.getText() != null) {
            HashMap<String, String> map = new HashMap<String, String>();
            final String text = tab.getText().toString();
            city = text;
            apiTest();
        }
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
