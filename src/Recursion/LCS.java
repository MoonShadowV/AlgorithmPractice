package Recursion;

/**
 * Created by ShadowMoon on 2017/10/1.
 */
public class LCS {
    public int[][] getDP(char[] str1,char[] str2){
        //initialize the dp array
        int m = str1.length;
        int n = str2.length;
        int[][] dp = new int[m][n];

        //get the initial status
        dp[0][0] = str1[0] == str2[0] ? 1 : 0;
        for (int i = 1;i < m;i++){
            dp[i][0] = Math.max(dp[i-1][0],str1[0] == str2[0] ? 1 : 0);
        }
        for (int j = 1;j < n;j++){
            dp[0][j] = Math.max(dp[0][j-1],str1[0] == str2[0] ? 1 : 0);
        }

        //get the final dp array
        for (int i = 1;i < m;i++){
            for (int j = 1;j < n;j++){
                dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                if (str1[i] == str2[j]){
                    dp[i][j] = Math.max(dp[i][j],dp[i-1][j-1]+1);
                }
            }
        }
        return dp;
    }

    public String lcs(String str1,String str2){
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        // m, n, end is array index, so it's value should be array.length - 1
        int m = s1.length - 1;
        int n = s2.length - 1;
        int[][] dp = getDP(s1,s2);
        char[] res = new char[dp[m][n]];
        int end = res.length - 1;

        //find the lcs
        while (end >= 0){
            if (m > 0 && dp[m][n] == dp[m-1][n]){
                m--;
            }
            else if (n > 0 && dp[m][n] == dp[m][n-1]){
                n--;
            }
            else{
                res[end] = s1[m];
                end--;
                m--;
                n--;
            }
        }

        return String.valueOf(res);
    }
}
