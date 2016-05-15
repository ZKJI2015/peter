package com.baidu.apistore.sdk.weather;

/**
 * Created by peter on 16/5/15.
 */
public class Basic {

    @Override
    public String toString() {
        return "Basic{" +
                "city='" + city + '\'' +
                ", cnty='" + cnty + '\'' +
                ", id='" + id + '\'' +
                ", lat='" + lat + '\'' +
                ", lon='" + lon + '\'' +
                ", update=" + update +
                '}';
    }

    private String city;

    private String cnty;

    private String id;

    private String lat;

    private String lon;

    private Update update;

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return this.city;
    }

    public void setCnty(String cnty) {
        this.cnty = cnty;
    }

    public String getCnty() {
        return this.cnty;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLat() {
        return this.lat;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getLon() {
        return this.lon;
    }

    public void setUpdate(Update update) {
        this.update = update;
    }

    public Update getUpdate() {
        return this.update;
    }

}
