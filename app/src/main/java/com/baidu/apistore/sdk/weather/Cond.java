package com.baidu.apistore.sdk.weather;

/**
 * Created by peter on 16/5/15.
 */
public class Cond {
    private String code;

    private String txt;

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    public String getTxt() {
        return this.txt;
    }

    @Override
    public String toString() {
        return "Cond{" +
                "code='" + code + '\'' +
                ", txt='" + txt + '\'' +
                '}';
    }
}
