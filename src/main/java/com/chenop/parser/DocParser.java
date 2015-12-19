package com.chenop.parser;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Chen.Oppenhaim on 12/19/2015.
 */
public class DocParser implements IParser {
    private final WordExtractor wordExtractor;

    public DocParser(InputStream inputStream) throws IOException {
        HWPFDocument document = new HWPFDocument(inputStream);
        wordExtractor = new WordExtractor(document);
    }

    @Override
    public String getText() {
        return wordExtractor.getText();
    }
}
