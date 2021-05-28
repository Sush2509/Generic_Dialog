package com.example.genericdialogue;

import java.io.Serializable;

public class DialogData implements Serializable {

    private int image;
    private String title,msg;
    private int iconBg;

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getIconBg() {
        return iconBg;
    }

    public void setIconBg(int iconBg) {
        this.iconBg = iconBg;
    }
}
