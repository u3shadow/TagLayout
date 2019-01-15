package com.u3coding.taglayout;

public class TagBean {
    //背景颜色
    int bgColor;

    //文字描述
    String src;

    public TagBean(int bgColor, String src) {
        this.bgColor = bgColor;
        this.src = src;
    }

    public int getBgColor() {
        return bgColor;
    }

    public void setBgColor(int bgColor) {
        this.bgColor = bgColor;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }
}
