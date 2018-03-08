package com.cyh.h5demo;

/**
 * @author youhai.cai
 *         create by 2018/3/7 15:39.
 */

public class FriendsZone {
    private String name;
    private String icon;
    private String content;

    public FriendsZone() {
    }

    public FriendsZone(String name, String icon, String content) {
        this.name = name;
        this.icon = icon;
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
