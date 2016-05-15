package com.baidu.apistore.sdk.weather;

/**
 * Created by peter on 16/5/15.
 */
public class Update {
    private String loc;

    private String utc;

    public void setLoc(String loc){
        this.loc = loc;
    }

    public String getLoc() {
        return this.loc;
    }

    public void setUtc(String utc) {
        this.utc = utc;
    }

    public String getUtc() {
        return this.utc;
    }

    @Override
    public String toString() {
        return "Update{" +
                "loc='" + loc + '\'' +
                ", utc='" + utc + '\'' +
                '}';
    }
}
