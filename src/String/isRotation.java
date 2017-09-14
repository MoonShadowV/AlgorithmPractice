package String;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ShadowMoon on 2017/9/14.
 */
public class isRotation {
    public boolean judge(String a,String b){
        if (a == null || b == null || a.length() != b.length()){
            return false;
        }
        String tmp = b+b;
        int pos = tmp.indexOf(a);
        if (pos == -1){
            System.out.println("false");
            return false;
        }
        return true;
    }

    public static void main(String[] args){
        isRotation i = new isRotation();
        i.judge("cadb","abcd");
    }
}
