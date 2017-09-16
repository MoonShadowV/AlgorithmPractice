package String;

/**
 * Created by ShadowMoon on 2017/9/16.
 */
//P253
public class getCountString {
    public String get(String cstr){
        String[] str = cstr.split("_");
        int i = 0;
        int num = 0;
        String res = "";
        while (i != str.length){
            num = Integer.valueOf(str[i+1]);
            while (num-- != 0){
                res+= str[i];
            }
            i = i+2;
        }
        return res;
    }

    public static void main(String[] args){
        String str = "a_3_b_2_a_1_d_3";
        String p = new getCountString().get(str);
        System.out.println(p);
        return;
    }
}
