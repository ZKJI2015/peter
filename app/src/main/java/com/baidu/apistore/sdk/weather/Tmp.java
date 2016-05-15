package com.baidu.apistore.sdk.weather;

/**
 * Created by peter on 16/5/15.
 */
public class Tmp {
    private String max;

    private String min;

    public void setMax(String max) {
        this.max = max;
    }

    public String getMax() {
        return this.max;
    }

    public void setMin(String min) {
        this.min = min;
    }

    public String getMin() {
        return this.min;
    }

    @Override
    public String toString() {
        return "Tmp{" +
                "max='" + max + '\'' +
                ", min='" + min + '\'' +
                '}';
    }
}
