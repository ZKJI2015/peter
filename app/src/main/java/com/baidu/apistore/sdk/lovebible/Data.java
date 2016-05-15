package com.baidu.apistore.sdk.lovebible;

/**
 * Created by peter on 16/5/15.
 */
public class Data {

    @Override
    public String toString() {
        return "Data{" +
                "id=" + id +
                ", valid=" + valid +
                ", body='" + body + '\'' +
                ", title='" + title + '\'' +
                '}';
    }

    private int id;

    private int valid;

    private String body;

    private String title;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setValid(int valid) {
        this.valid = valid;
    }

    public int getValid() {
        return this.valid;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getBody() {
        return this.body;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

}
