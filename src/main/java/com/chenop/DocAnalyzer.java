package com.chenop;

import com.chenop.db.DBHelper;
import com.chenop.models.CVData;
import com.chenop.models.CaseInsensitiveList;

import java.util.*;

/**
 * Created by Chen.Oppenhaim on 12/20/2015.
 */
public class DocAnalyzer {

    public static List<String> extractKeywords(String text) {
        CaseInsensitiveList keywords = getKeywords();
        List<String> foundKeywords = new ArrayList<>();

        if (text == null || text.isEmpty())
            return foundKeywords;

        String delimiters = "\\s+|,\\s*";
        String[] words = text.split(delimiters);

        for (String word : words) {
            String keyword = keywords.containsAndGetKeyword(word);
            if (keyword != null && !foundKeywords.contains(keyword))
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

    public static CVData extractCVData(String text) {
        List<String> keywords = extractKeywords(text);

        CVData cvData = new CVData(keywords);

        return cvData;
    }
}
