package Recursion;

/**
 * Created by ShadowMoon on 2017/9/25.
 */
public class MinPath {
    int getPath(int[][] weight){
        int m = weight.length;
        int n = weight[0].length;
        int[][] dp =  new int[m][n];

        //initialize the dp array
        for (int i = 0;i < m;i++){
            if (i == 0 ){
                for (int j = 0;j < n;j++){
                    dp[i][j] = j == 0 ? weight[i][j]:dp[i][j-1]+weight[i][j];
                }
            }else {
                dp[i][0] = dp[i-1][0]+weight[i][0];
            }
        }
        //find the minimum path
        for(int i = 1;i < m;i++){
            for (int j = 1;j < n;j++){
                dp[i][j] = Math.min(dp[i-1][j]+weight[i][j],dp[i][j-1]+weight[i][j]);
            }
        }
        return dp[m-1][n-1];
    }
}
