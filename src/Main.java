import java.util.HashMap;
import java.util.Map;

public class Main {

    private void quickSort(int[] array,int low ,int high){
        if(low > high){
            return;
        }

        int i = low, j = high,key = array[low];
        int temp = 0;


        while (i != j){
            while (array[j] >= key && i < j){
                j--;
            }
            while (array[i] <= key && i < j){
                i++;
            }
            if (i < j){
                temp = array[j];
                array[j] = array[i];
                array[i] = temp;
            }
        }
        temp = array[low];
        array[low] = array[i];
        array[i] = temp;

        quickSort(array,low,i-1);
        quickSort(array,i+1,high);
    }

    //
    private int[] twoSum(int[] nums,int target){
        int [] result = new int[2];
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for (int i = 0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                result[0] = map.get(target-nums[i]);
                result[1] = i;
                return result;
            }
            map.put(nums[i],i);
        }
        return result;
    }
    //Leetcode的第一题，使用Map来降低查找时间，使得时间复杂度降低到	O（N），从而得以通过OJ
//主要是先把所有的输入都装进Map里，然后通过Map查找是否存在【target-nums[i]】的值，如果存在，就取出其下标。

    private String[] grayCode(int n){
        String[] graycode = new String[(int) Math.pow(2,n)];

        if (n == 1){
            graycode[0] = "0";
            graycode[1] = "1";
            return graycode;
        }

        String[] preGrayCode = grayCode(n-1);

        for (int i = 0;i < preGrayCode.length; i++){
            graycode[i] = "0"+preGrayCode[i];
            graycode[graycode.length-1-i] = "1"+preGrayCode[i];
        }

        return graycode;
    }
    //递归生成格雷码，经典面试编程题
    //在一组数的编码中，若任意两个相邻的代码只有一位二进制数不同，则称这种编码为格雷码
    // N 位格雷码的数量为2的N次幂
    //由于格雷码是循环码，最大数与最小数之间仅一位不同，N位格雷码可以靠N-1位格雷码，推导出来。
    //每个N-1位格雷码可以通过添加前缀0和1的方式生成两个N位格雷码
    //所以可以考虑使用递归的方法生成格雷码

    public int getValue(int[] gifts, int n) {
        // write code here
        int value = gifts[0];
        int times = 1;
        for(int i:gifts){
            if(value != i){
                times--;
            }else{
                times++;
            }
            if(times == 0){
                value = i;
                times = 1;
            }
        }
        if(times > 1){
            return value;
        }else{
            return 0;
        }
    }
    /*
    微信红包
    时间限制：3秒
    空间限制：32768K
    春节期间小明使用微信收到很多个红包，非常开心。在查看领取红包记录时发现，某个红包金额出现的次数超过了红包总数的一半。请帮小明找到该红包金额。写出具体算法思路和代码实现，要求算法尽可能高效。
    给定一个红包的金额数组gifts及它的大小n，请返回所求红包的金额。
    若没有金额超过总数的一半，返回0。
    测试样例：
    [1,2,3,2,2],5
    返回：2
    */
    //可以发现，题目给出的数组是非常特别的，数组超过一半的元素可能是某个特定值。
    //可以添加两个辅助值,times，初始值为1,value，初始值为数组第一个元素。按照正序遍历数组，如果下一个元素和value不同，则times--。如果times==0，则把times重设为1，value设置为该元素。
    //这样做的好处是，如果存在一个数值占据的长度超过数组的一半，那么到最后，times的值必然大于其初始值，否则的话，没有一个数值占据的长度超过数组的一半。


    public static void main(String[] args) {
        Main obj = new Main();
        int[] array = new int[]{1,2,3,2,2,3};
        int n = array.length;
        obj.getValue(array,n);
        System.out.println(array);
    }
}
