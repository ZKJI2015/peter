package com.baidu.apistore.sdk.laugh;

/**
 * Created by peter on 16/5/15.
 */
public class Contentlist {

    @Override
    public String toString() {
        return "Contentlist{" +
                "ct='" + ct + '\'' +
                ", id='" + id + '\'' +
                ", text='" + text + '\'' +
                ", title='" + title + '\'' +
                ", type=" + type +
                '}';
    }

    private String ct;

    private String id;

    private String text;

    private String title;

    private int type;

    public void setCt(String ct) {
        this.ct = ct;
    }

    public String getCt() {
        return this.ct;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getType() {
        return this.type;
    }

}
