package Recursion;

/**
 * Created by ShadowMoon on 2017/9/25.
 */
public class MinCoin {
    int findMin(int[] arr,int aim){
        int n = arr.length;
        int max = Integer.MAX_VALUE;
        int[][] dp = new int[n][aim+1];//[n] --> arr[n]  || [aim+1] --> value from 0 to aim
        //dp[i][j] = min{dp[i-1][j] , dp[i][j - arr[i]] + 1}
        //             not use arr[i] ||  use arr[i]

        for (int j = 1; j <= aim;j++){
            dp[0][j] = max;
            if (j - arr[0] >= 0 && dp[0][j - arr[0]] != max){
                dp[0][j] = dp[0][j - arr[0]]+1;
            }
        }
        int tmp = 0;
        for (int i = 1; i < n;i++){
            for (int j = 1; j <= aim;j++){
                tmp = max;
                if (j - arr[i] >= 0 && dp[i][j - arr[i]] != max){
                    tmp = dp[i][j - arr[i]] + 1;
                }
                dp[i][j] = Math.min(tmp,dp[i-1][j]);
            }
        }

        return dp[n-1][aim] != max ? dp[n-1][aim] : -1;
    }
}
