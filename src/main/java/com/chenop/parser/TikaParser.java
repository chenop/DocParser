package com.chenop.parser;

import org.apache.tika.Tika;
import org.apache.tika.exception.TikaException;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Chen.Oppenhaim on 12/19/2015.
 */
public class TikaParser implements IParser {

    Tika tika = new Tika();
    private InputStream inputStream;

    public TikaParser(InputStream inputStream) throws IOException {
        this.inputStream = inputStream;
    }

    @Override
    public String getText() {
        try {
            return tika.parseToString(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TikaException e) {
            e.printStackTrace();
        }
        return null;
    }
}
