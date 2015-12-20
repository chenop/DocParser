package com.chenop;

import java.util.ArrayList;

/**
 * Created by Chen.Oppenhaim on 12/20/2015.
 */
public class CaseInsensitiveList extends ArrayList<String> {
    @Override
    public boolean contains(Object o) {
        String paramStr = (String) o;
        for (String s : this) {
            if (paramStr.equalsIgnoreCase(s)) return true;
        }
        return false;
    }

    public String containsAndGetKeyword(String k) {
        for (String s : this) {
            if (k.equalsIgnoreCase(s)) return s;
        }
        return null;
    }
}
