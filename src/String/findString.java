package String;

/**
 * Created by ShadowMoon on 2017/9/17.
 */
//P259
public class findString {
    public int find(String[] strs,String str){
        if (strs == null || strs.length == 0 || str == null){
            return -1;
        }
        int res = -1;
        int left = 0;
        int right = strs.length-1;
        while (left <= right){
            int mid = (left+right)/2;
            if (strs[mid].equals(str)){
                res = mid;
                right = mid-1;
            }
            else if (strs[mid] != null){
                if (strs[mid].compareTo(str) < 0){
                    left = mid+1;
                }else {
                    right = mid-1;
                }
            }
            else if (strs[mid] == null){
                int i = mid;
                while (i >= left && strs[i] == null ){i--;}
                if (i < left || strs[i].compareTo(str) < 0){
                    left = mid + 1;
                }else {
                    res = strs[i].equals(str) ? i : res;
                    right = i - 1;
                }
//                else if(strs[i].equals(str)){
//                    res = i;
//                    right = i - 1;
//                }
//                else if (strs[i].compareTo(str) > 0){
//                    right = i - 1;
//                }
            }
        }
        return res;
    }
}
