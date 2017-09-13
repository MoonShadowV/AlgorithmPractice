package String;

/**
 * Created by ShadowMoon on 2017/9/13.
 */
//P244
public class numSum {
    public int getSum(String str){
        if (str == null){
            return 0;
        }
        char[] chars = str.toCharArray();
        int res = 0;
        int num = 0;
        int cur = 0;
        boolean pos = true;
        for (int i = 0;i < chars.length;i++){
            cur = chars[i]-'0';
            if (cur < 0 || cur > 9){
                res += num;
                num = 0;
                if (chars[i] == '-'){
                    if (i - 1 > -1 && chars[i - 1] == '-'){
                        pos = !pos;
                    }else {
                        pos = false;
                    }
                }
            }else {
                num = num * 10 + (pos ? num:-num);
            }
        }
        res += num;
        return res;
    }
}
