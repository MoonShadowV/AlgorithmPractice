package String;

/**
 * Created by ShadowMoon on 2017/9/16.
 */
//P252
public class ReplaceString {
    public String replace(String str,String from,String to){
        int match = 0;
        char[] s = str.toCharArray();
        char[] f = from.toCharArray();
        char[] t = to.toCharArray();
        for (int i = 0;i < s.length;i++){
            if (s[i] == f[match]){
                if (match == f.length){
                    int len  = f.length;
                    while (len-- != 0){
                        s[i--] = 0;
                    }
                    match = 0;
                }
                match++;
            }else {
                if(s[i] == f[0]){
                    i--;
                }
                match = 0;
            }
        }
        String cur = "";
        String res = "";
        for (int i = 0;i < s.length;i++){
            if (s[i] != 0){
                cur = cur + String.valueOf(s[i]);
            }
            if (s[i] == 0 && (i == 0 || s[i-1]==0)){
                res = res+cur+to;
                cur = "";
            }
            if (!cur.equals("")){
                res = res+cur;
            }
        }
        return res;
    }
}
