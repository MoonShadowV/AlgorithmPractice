package DesignPatternPractice.AdapterPattern;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class FileProperties extends Properties implements FileIO {
    private String key;
    private String value;

    @Override
    public void write(String fileName) throws IOException {
        FileOutputStream out = new FileOutputStream(fileName);
        store(out,"Just a test");
    }

    @Override
    public void read(String fileName) throws IOException {
        FileInputStream in = new FileInputStream(fileName);
        load(in);
    }

    @Override
    public void setValue(String key, String value) {
        setProperty(key,value);
    }

    @Override
    public String getValue(String key) {
        return getProperty(key,"");
    }
}
