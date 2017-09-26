package Recursion;

/**
 * Created by ShadowMoon on 2017/9/26.
 */
public class ExchangeCoin {
    int getMethodsNum(int[] arr,int aim){
        return 0;
    }

    int memorySearch(int[] arr,int aim,int progress,int[][] globalMap){
        int res = 0;
        if (progress == arr.length){
            res = aim == 0 ? 1 : 0;
        }else {
            int mapValue = 0;
            for (int i = 0; arr[progress] * i <= aim;i++){
                mapValue = globalMap[progress+1][aim - arr[progress] * i];//try to get the mapValue
                if (mapValue != 0){
                    res += mapValue == -1 ? 0 : mapValue;
                }else {
                    res += memorySearch(arr,aim - arr[progress] * i,progress+1,globalMap);
                }
            }
        }
        globalMap[progress][aim] = res == 0 ? -1:res;
        return res;
    }

    int dpWay(int[] arr,int aim){
        if (arr == null || arr.length == 0 || aim < 0){
            return 0;
        }
        int [][] dp = new int[arr.length][aim+1];
        for (int i = 0;i < arr.length;i++){
            dp[i][0] = 1;
        }
        for (int i = 0;i < aim+1;i++){
            dp[0][i*arr[0]] = 1;
        }

        for (int i = 1;i < arr.length;i++){
            for (int j = 1;j < aim+1;j++){
                int way = 0;
                for (int k = 0;k  * arr[i]  <= j;k++){
                    way += dp[i-1][j - k*arr[i]];
                }
                dp[i][j] = way;//update the dp array
            }
        }

        return dp[arr.length-1][aim];
    }

    int dpWay_Plus(int[] arr,int aim){
        if (arr == null || arr.length == 0 || aim < 0){
            return 0;
        }
        int [][] dp = new int[arr.length][aim+1];
        for (int i = 0;i < arr.length;i++){
            dp[i][0] = 1;
        }
        for (int i = 0;i < aim+1;i++){
            dp[0][i*arr[0]] = 1;
        }

        for (int i = 1;i < arr.length;i++){
            for (int j = 1;j < aim+1;j++){
                dp[i][j] = dp[i-1][j];
                dp[i][j] += j - arr[i] >= 0 ? dp[i][j- arr[i]] : 0;//update the dp array
            }
        }
        return dp[arr.length-1][aim];
    }
}
