package com.pf.org.cms.entity;

import java.io.Serializable;

/**
 * @Auther: pf
 * @Date: 2017/12/13 15:38
 * @Description:
 */
public class JsonBean implements Serializable {
    private static final long serialVersionUID = 1L;

    // 状态码:0是成功 1是失败
    private int status;

    // 异常或其他主要提示信息
    private String message;

    // 返回的具体数据
    private Object data;

    public JsonBean() {
        status = 0;
        message = "";
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "JsonBean [status=" + status + ", message=" + message
                + ", jsonData=" + String.valueOf(data) + "]";
    }
}
