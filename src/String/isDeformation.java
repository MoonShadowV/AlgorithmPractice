package String;

import java.util.HashMap;
import java.util.Set;

/**
 * Created by ShadowMoon on 2017/9/12.
 */
//P243
public class isDeformation {
    public Boolean judge(String s1,String s2){
        if (s1.length() != s2.length()){
            return false;
        }
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        int[] map = new int[256];
        for(int i=0;i < chars1.length;i++){
            map[chars1[i]]++;
        }
        for (int i=0;i < chars2.length;i++){
            if (map[chars2[i]]-- == 0){
                return false;
            }
        }
        return true;
    }

    public Boolean judge_hash(String s1,String s2){
        if (s1.length() !=  s2.length()){
            return false;
        }
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i= 0; i < chars1.length; i++){
            if (map.containsKey(chars1[i])){
                map.put(chars1[i],map.get(chars1[i])+1);
            }else {
                map.put(chars1[i],1);
            }
        }
        for (int i = 0;i < chars2.length;i++){
            if (map.containsKey(chars2[i])){
                map.put(chars2[i],map.get(chars2[i])-1);
                if (map.get(chars2[i]) < 0){
                    return false;
                }
            }else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        String s1 = "123";
        String s2 = "231";
        isDeformation j = new isDeformation();
        if (j.judge_hash(s1,s2)){
            System.out.print("True");
        }else {
            System.out.print("False");
        }
    }
}
