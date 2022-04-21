package com.flannery;

import java.lang.reflect.Array;
import java.util.Arrays;

public class main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        int[] res = new int[11];
        Arrays.fill(res,12);
        for (int re : res) {
            System.out.println(re);
        }
    }

    public static int coinChange(int[] coins, int amount) {
        if(coins.length == 0) return 0;
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;
        for(int i = 1; i <= amount; i++) {
            for(int j = 0; j < coins.length; j++) {
                if(coins[j] <= i) { // 还够找零
                    dp[i] = Math.min(dp[i], dp[i-1]+1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

}
