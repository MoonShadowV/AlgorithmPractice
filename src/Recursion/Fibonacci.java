package Recursion;

/**
 * Created by ShadowMoon on 2017/9/19.
 */
public class Fibonacci {
    public int f1(int n){
        if (n <= 0){
            return 0;
        }
        if (n == 1 || n == 2){
            return  1;
        }
        return f1(n-1)+f1(n-2);
    }

    public int f2(int n){
        if (n <= 0){
            return 0;
        }
        if (n == 1 || n == 2){
            return  1;
        }
        int res = 1;
        int pre = 1;
        int tmp = 0;
        for (int i = 3;i <= n;i++){
            tmp = res;
            res = pre+res;
            pre = tmp;
        }
        return res;
    }
}
