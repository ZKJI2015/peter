package com.baidu.apistore.sdk.lovebible;

import java.util.List;

/**
 * Created by peter on 16/5/15.
 */
public class Root {

    @Override
    public String toString() {
        return "Root{" +
                "status=" + status +
                ", data=" + data +
                ", msg='" + msg + '\'' +
                '}';
    }

    private int status;

    private List<Data> data;

    private String msg;

    public void setStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return this.status;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    public List<Data> getData() {
        return this.data;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return this.msg;
    }

}
