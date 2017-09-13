package String;

/**
 * Created by ShadowMoon on 2017/9/13.
 */
//P246
public class removeKZeros {
    public String remove(String str,int k){
        char[] chars = str.toCharArray();
        int count = 0;
        int start = -1;
        for (int i = 0;i < chars.length; i++){
            if (chars[i] == '0'){
                start = start == -1?i:start;
                count++;
            }
            else {
                if (count == k){
                    while (count-- != 0){
                        chars[start++] = 0;
                    }
                }
                count = 0;
                start = -1;
            }
        }
        if (count == k){
            while (count-- != 0){
                chars[start++] = 0;
            }
        }
        return String.valueOf(chars);
    }

    public static void main(String[] args){
        String str1 = "A00B";
        String str2 = "A0000B000";
        removeKZeros r = new removeKZeros();
        System.out.println(r.remove(str1,2));
        System.out.println(r.remove(str2,4));
    }
}
