package String;

/**
 * Created by ShadowMoon on 2017/9/14.
 */
public class ConvertNum {
    public int convert(String str){
        if(!isValid(str)){
            return 0;
        }
        char[] chars = str.toCharArray();
        boolean posi = chars[0] == '-' ? false:true;
        int res = 0;
        int minNum = Integer.MIN_VALUE/10;
        int min =   Integer.MIN_VALUE%10;
        int cur = 0;

        for (int i = posi ? 0:1;i < chars.length;i++){
            cur = '0' - chars[i];
            if (res < minNum || (res == minNum && cur < min)){
                return 0;
            }
            res = res * 10 + cur;
        }
        if (posi && res == Integer.MIN_VALUE){//MIN_VALUE比MAX_VALUE绝对值大1
            return 0;
        }
        return posi ? res : -res;
    }

    public boolean isValid(String str){
        char[] chars = str.toCharArray();
        if (chars[0] != '-' && (chars[0] < '0' || chars[0] > '9')){//字母开头
            return false;
        }
        else if (chars[0] != '-' && (chars.length == 1 || chars[1] == '0')){//-或接0
            return false;
        }
        else if(chars[0] == '0' && chars.length > 1){//0开头
            return false;
        }
        return true;
    }
}
