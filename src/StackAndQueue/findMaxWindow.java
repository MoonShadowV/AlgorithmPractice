package StackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by ShadowMoon on 2017/8/27.
 */
public class findMaxWindow {
    public int[] find(int[] arr,int window){
        int[] maxWindow = new int[arr.length-window+1];
        if (arr.length < window || arr == null || window < 1){
            return null;
        }
        for (int i = 0;i < arr.length-window+1;i++){
            for (int j = i;j < i+window;j++){
                if (maxWindow[i] < arr[j]){
                    maxWindow[i] = arr[j];
                }
            }
        }
        return maxWindow;
    }

    public static void main(String[] args){
        int[] arr = {4,3,5,4,3,3,6,7};
        int window = 3;
        findMaxWindow f = new findMaxWindow();
        int[] maxWindow = f.find(arr,window);


        for (int i:maxWindow){
            System.out.print(i);
        }
    }
}
