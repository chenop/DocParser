package com.chenop.models;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Chen on 23/10/2015.
 */
@XmlRootElement
public class Track {
    String title;
    String singer;

    public Track() {
    }

    public Track(String title, String singer) {
        this.title = title;
        this.singer = singer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }
}
