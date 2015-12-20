package com.chenop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Chen.Oppenhaim on 12/20/2015.
 */
public class KeywordsAnalyzer {

    public static List<String> extractKeywords(String text) {
        CaseInsensitiveList keywords = getKeywords();
        List<String> foundKeywords = new ArrayList<>();

        if (text == null || text.isEmpty())
            return Collections.emptyList();

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
        CaseInsensitiveList keywords = new CaseInsensitiveList();
        keywords.add("C#");
        keywords.add("AngularJS");
        keywords.add("GUI");
        keywords.add("Java");
        keywords.add("JavaScript");
        return keywords;
    }
}
