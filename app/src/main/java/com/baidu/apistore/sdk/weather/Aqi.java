package com.baidu.apistore.sdk.weather;

/**
 * Created by peter on 16/5/15.
 */
public class Aqi {

    @Override
    public String toString() {
        return "Aqi{" +
                "city=" + city +
                '}';
    }

    private City city;

    public void setCity(City city) {
        this.city = city;
    }

    public City getCity() {
        return this.city;
    }

}
