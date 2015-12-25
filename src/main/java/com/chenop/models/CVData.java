package com.chenop.models;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by Chen on 23/10/2015.
 */
@XmlRootElement
public class CVData {

    List<String> keywords;

    public CVData() {
    }

    public CVData(List<String> keywords) {
        this.keywords = keywords;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }
}
