package String;

/**
 * Created by ShadowMoon on 2017/9/18.
 */
public class ReverseString {
    public void deal(char[] chars){
        //firstly, reverse the chars array
        reverse(chars,0,chars.length-1);
        int wBegin = -1;
        int wEnd = -1;
        //then, reverse each of the words
        for (int i = 0;i < chars.length; i++){
            wBegin = i==0 || chars[i-1] == ' '? i:wBegin;
            wEnd = i == chars.length-1 || chars[i+1] == ' '? i:wEnd;
            if (wBegin != -1 && wEnd != -1){
                reverse(chars,wBegin,wEnd);
                wBegin = -1;
                wEnd = -1;
            }
        }
    }

    public void reverse(char[] chars,int start,int end){
        char tmp = 0;
        while (start < end){
            tmp = chars[start];
            chars[start] = chars[end];
            chars[end] = tmp;
            start++;
            end--;
        }
    }

    public void deal2(char[] chars,int size){
        char tmp = 0;
        reverse(chars,0,size-1);
        reverse(chars,size,chars.length-1);
        reverse(chars,0,chars.length-1);
    }
}

