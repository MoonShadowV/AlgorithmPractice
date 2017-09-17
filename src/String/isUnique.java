package String;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ShadowMoon on 2017/9/17.
 */
public class isUnique {
    public boolean judge(char[] chars){
        Set<Character> set = new HashSet<Character>();
        for (int i = 0;i < chars.length;i++){
            if (set.contains(chars[i])){
                return false;
            }else {
                set.add(chars[i]);
            }
        }
        return true;
    }
}
