package com.baidu.apistore.sdk.weather;

/**
 * Created by peter on 16/5/15.
 */
public class Astro {

    @Override
    public String toString() {
        return "Astro{" +
                "sr='" + sr + '\'' +
                ", ss='" + ss + '\'' +
                '}';
    }

    private String sr;

    private String ss;

    public void setSr(String sr) {
        this.sr = sr;
    }

    public String getSr() {
        return this.sr;
    }

    public void setSs(String ss) {
        this.ss = ss;
    }

    public String getSs() {
        return this.ss;
    }

}
