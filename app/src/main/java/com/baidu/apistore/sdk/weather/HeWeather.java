package com.baidu.apistore.sdk.weather;

import java.util.List;

/**
 * Created by peter on 16/5/15.
 */
public class HeWeather {
    private Basic basic;

    private List<Daily_forecast> daily_forecast;

    private List<Hourly_forecast> hourly_forecast;

    private Now now;

    private String status;

    private Suggestion suggestion;

    public void setBasic(Basic basic) {
        this.basic = basic;
    }

    public Basic getBasic() {
        return this.basic;
    }

    public void setDaily_forecast(List<Daily_forecast> daily_forecast) {
        this.daily_forecast = daily_forecast;
    }

    public List<Daily_forecast> getDaily_forecast() {
        return this.daily_forecast;
    }

    public void setHourly_forecast(List<Hourly_forecast> hourly_forecast) {
        this.hourly_forecast = hourly_forecast;
    }

    public List<Hourly_forecast> getHourly_forecast() {
        return this.hourly_forecast;
    }

    public void setNow(Now now) {
        this.now = now;
    }

    public Now getNow() {
        return this.now;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return this.status;
    }

    public void setSuggestion(Suggestion suggestion) {
        this.suggestion = suggestion;
    }

    public Suggestion getSuggestion() {
        return this.suggestion;
    }

    @Override
    public String toString() {
        return "HeWeather{" +
                "basic=" + basic +
                ", daily_forecast=" + daily_forecast +
                ", hourly_forecast=" + hourly_forecast +
                ", now=" + now +
                ", status='" + status + '\'' +
                ", suggestion=" + suggestion +
                '}';
    }
}