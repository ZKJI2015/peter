package com.baidu.apistore.sdk;


import android.app.ActivityGroup;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RadioButton;
import android.widget.TabHost;

import com.baidu.apistore.sdk.laugh.LaughActivity;
import com.baidu.apistore.sdk.lovebible.LoveibleActivity;
import com.baidu.apistore.sdk.weather.MainActivity;

public class MainTab extends ActivityGroup implements OnClickListener {
    public static final String TAB_LIVING = "living";
    public static final String TAB_LOCAL = "local";
    public static final String TAB_ClASSIFY = "classify";
    public static final String TAB_MY = "my";
    private TabHost mHost;
    private Intent intentLiving, intentLocal, intentClassify, intentMy;
    private RadioButton btnLiving, btnLocal, btnClassify, btnMy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.tab_main);
        btnLiving = (RadioButton) findViewById(R.id.tabmain_living);
        btnLocal = (RadioButton) findViewById(R.id.tabmain_local);
        btnClassify = (RadioButton) findViewById(R.id.tabmain_classify);
        btnMy = (RadioButton) findViewById(R.id.tabmain_my);
        btnLiving.setOnClickListener(this);
        btnLocal.setOnClickListener(this);
        btnClassify.setOnClickListener(this);
        btnMy.setOnClickListener(this);
        mHost = (TabHost) findViewById(R.id.tabhost);
        mHost.setup(this.getLocalActivityManager());
        initTabs();

        btnClassify.setChecked(true);
        mHost.setCurrentTabByTag(TAB_ClASSIFY);
    }


    private void initTabs() {
        intentClassify = new Intent(this, MainActivity.class);
        intentLiving = new Intent(this, LaughActivity.class);
        intentLocal = new Intent(this, LoveibleActivity.class);
        intentMy = new Intent(this, MainActivity.class);
        mHost.addTab(buildTabSpec(TAB_ClASSIFY, TAB_LIVING, R.drawable.tab_home_nor, intentClassify));
        mHost.addTab(buildTabSpec(TAB_LIVING, TAB_LIVING, R.drawable.tab_live_nor, intentLiving));
        mHost.addTab(buildTabSpec(TAB_LOCAL, TAB_LIVING, R.drawable.tab_local_nor, intentLocal));
        mHost.addTab(buildTabSpec(TAB_MY, TAB_LIVING, R.drawable.tab_my_nor, intentMy));
    }

    private TabHost.TabSpec buildTabSpec(String tag, String resLabel, int resIcon, final Intent content) {
        return this.mHost.newTabSpec(tag).setIndicator(resLabel, getResources().getDrawable(resIcon))
                .setContent(content);
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onClick(View arg0) {
        switch (arg0.getId()) {
            case R.id.tabmain_living:
                mHost.setCurrentTabByTag(TAB_LIVING);
                btnMy.setChecked(false);//加BadgeView
                break;
            case R.id.tabmain_local:
                mHost.setCurrentTabByTag(TAB_LOCAL);
                btnMy.setChecked(false);//加BadgeView
                break;
            case R.id.tabmain_classify:
                mHost.setCurrentTabByTag(TAB_ClASSIFY);
                btnMy.setChecked(false);//加BadgeView
                break;
            case R.id.tabmain_my:
                mHost.setCurrentTabByTag(TAB_MY);
                btnLiving.setChecked(false);//加BadgeView
                btnLocal.setChecked(false);//加BadgeView
                btnClassify.setChecked(false);//加BadgeView
                break;
        }
    }

}
