package String;
/**
 * Created by ShadowMoon on 2017/9/18.
 */
public class MinDistance {
    public int getDistance(String[] strs,String str1,String str2){
        if (str1 == null || str2 == null || strs == null){
            return -1;
        }
        if (str1.equals(str2)){
            return 0;
        }
        int last1 = -1;
        int last2 = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0;i < strs.length;i++){
            if (strs[i].equals(str1)){
                last1=i;
                min = Math.min(min,last2 == -1?min:i-last2);
            }
            if (strs[i].equals(str2)){
                last2=i;
                min = Math.min(min,last1 == -1?min:i-last1);
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
