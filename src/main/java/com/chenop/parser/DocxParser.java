package com.chenop.parser;

import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Chen.Oppenhaim on 12/19/2015.
 */
public class DocxParser implements IParser {
    private final XWPFWordExtractor wordExtractor;

    public DocxParser(InputStream inputStream) throws IOException {
        XWPFDocument document = new XWPFDocument(inputStream);
        wordExtractor = new XWPFWordExtractor(document);
    }

    @Override
    public String getText() {
        return wordExtractor.getText();
    }
}
