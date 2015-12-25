package com.chenop;

import com.chenop.db.DBHelper;
import com.chenop.models.CaseInsensitiveList;

import java.util.*;

/**
 * Created by Chen.Oppenhaim on 12/20/2015.
 */
public class KeywordsAnalyzer {

    public static TreeSet<String> extractKeywords(String text) {
        CaseInsensitiveList keywords = getKeywords();
        TreeSet<String> foundKeywords = new TreeSet<>();

        if (text == null || text.isEmpty())
            return foundKeywords;

        String delimiters = "\\s+|,\\s*";
        String[] words = text.split(delimiters);

        for (String word : words) {
            String keyword = keywords.containsAndGetKeyword(word);
            if (keyword != null)
                foundKeywords.add(keyword);
        }

        return foundKeywords;
    }

    public static CaseInsensitiveList getKeywords() {
        TreeSet<String> result = DBHelper.INSTANCE.getKeywords();

        CaseInsensitiveList keywords = new CaseInsensitiveList();
        keywords.addAll(result);
        return keywords;
    }
}
