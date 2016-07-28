package com.chenop;

import com.chenop.common.Constants;
import com.chenop.db.DBHelper;
import com.chenop.models.CVData;
import com.chenop.models.CaseInsensitiveList;

import java.util.*;

/**
 * Created by Chen.Oppenhaim on 12/20/2015.
 */
public class DocAnalyzer {

    public static List<String> extractKeywords(String text, CaseInsensitiveList keywords) {
        List<String> foundKeywords = new ArrayList<>();

        if (text == null || text.isEmpty())
            return foundKeywords;

        String[] words = text.split(Constants.DELIMITERS);

        for (int i = 0; i < words.length; i++) {
            String firstWord = words[i];
            String secondWord = i + 1 < words.length ? words[i+1] : null;

            String keyword = keywords.containsAndGetKeyword(firstWord, secondWord);
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
        CaseInsensitiveList keywords = getKeywords();
        List<String> extractKeywords = extractKeywords(text, keywords);

        CVData cvData = new CVData(extractKeywords);

        return cvData;
    }
}
