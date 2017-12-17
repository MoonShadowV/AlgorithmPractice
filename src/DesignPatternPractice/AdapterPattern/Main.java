package DesignPatternPractice.AdapterPattern;

import java.io.IOException;

public class Main {
    public static void main(String[] args){
        FileIO f = new FileProperties();
        String path = "C:\\WorkPlace\\JAVA\\AlgorithmPractice\\src\\DesignPatternPractice\\AdapterPattern\\";
        try {
            f.read(path+"file.txt");
            System.out.println(f.getValue("year"));
            f.setValue("year","2004");
            f.setValue("month","4");
            f.setValue("day","21");
            f.write(path+"newFile.txt");
            System.out.println(f.getValue("year"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
