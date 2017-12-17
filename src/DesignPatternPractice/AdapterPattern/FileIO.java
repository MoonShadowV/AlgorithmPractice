package DesignPatternPractice.AdapterPattern;

import java.io.IOException;

public interface FileIO {
    void write(String fileName) throws IOException;
    void read(String filename) throws IOException;
    void setValue(String key,String value);
    String getValue(String key);
}
