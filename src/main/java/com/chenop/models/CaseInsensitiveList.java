package com.chenop.models;

import com.chenop.common.Constants;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chen.Oppenhaim on 12/20/2015.
 */
public class CaseInsensitiveList extends ArrayList<String> {
    public CaseInsensitiveList() {
    }

    public CaseInsensitiveList(List<String> array) {
        addAll(array);
    }

    @Override
    public boolean contains(Object o) {
        String paramStr = (String) o;
        for (String s : this) {
            if (paramStr.equalsIgnoreCase(s)) return true;
        }
        return false;
    }

    public String containsAndGetKeyword(String firstWord, String secondWord) {
        for (String keyword : this) {
            if (isTwoWords(keyword) && secondWord != null) {
                // keyword is 2 words
                if (keyword.contains(firstWord) && keyword.contains(secondWord))
                    return keyword;
            }
            // keyword only 1 word
            else if (firstWord.equalsIgnoreCase(keyword)) return keyword;
        }
        return null;
    }

    private boolean isTwoWords(String keyword) {
        String[] words = keyword.split(Constants.DELIMITERS);
        return (words.length == 2);
    }
}
