package com.chenop;

import com.chenop.parser.IParser;
import com.chenop.parser.TikaParser;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Chen.Oppenhaim on 12/19/2015.
 */
public class ParserManager {

    public static IParser getParser(InputStream inputStream, String extension) throws IOException {
        return new TikaParser(inputStream);
    }

    public static String parse(InputStream inputStream) throws IOException {
        TikaParser tikaParser = new TikaParser(inputStream);
        return tikaParser.getText();
    }
}
