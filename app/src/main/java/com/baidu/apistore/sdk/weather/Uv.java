package com.baidu.apistore.sdk.weather;

/**
 * Created by peter on 16/5/15.
 */
public class Uv {
    private String brf;

    private String txt;

    public void setBrf(String brf) {
        this.brf = brf;
    }

    public String getBrf() {
        return this.brf;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    public String getTxt() {
        return this.txt;
    }

    @Override
    public String toString() {
        return "Uv{" +
                "brf='" + brf + '\'' +
                ", txt='" + txt + '\'' +
                '}';
    }
}
