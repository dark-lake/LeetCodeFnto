import java.util.Arrays;

public class Bag01 {
    public int bag01(int[] weight, int[] value, int bagWeight) {
        int[][] dp = new int[weight.length][bagWeight + 1];
        for (int i = 0; i < weight.length; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < weight.length; i++) {
            for (int j = 1; j <= bagWeight; j++) {
                // 这里不处理第一行,因为第一行的话没办法求dp[i-1]
                if (i - 1 >= 0) {
                    // 其他行需要考虑j是不是大于这个物品的重量,如果不是就直接等于dp[i-1][j]就OK了
                    if (j >= weight[i]) {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - weight[i]] + value[i]);
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                } else {
                    // 这里就是第一行,也就是只考虑拿第一个物品的时候
                    if (j >= weight[i]) dp[i][j] = value[i];
                }
            }
        }
        for (int[] ints : dp) {
            System.out.println(Arrays.toString(ints));
        }
        return dp[weight.length - 1][bagWeight];
    }

    public int bag01V1(int[] weight, int[] value, int bagWeight) {
        int[] dp = new int[bagWeight + 1];
        dp[0] = 0;
        // 这一步其实是初始化dp
        for (int i = 1; i < dp.length; i++) {
            // 填充第一行,因为就一个物品,只有物品重量大于背包容量的时候才让dp[i]为0
            dp[i] = weight[0] > i ? 0 : value[0];
        }
        System.out.println(Arrays.toString(dp));
        // 直接从第二个物品开始
        for (int i = 1; i < weight.length; i++) {
            for (int j = 1; j < dp.length; j++) {
                // 只有当背包的容量大于
                if(j>=weight[i]){
                    // 此时可以放进去,但是要判断拿它的价值高还是不拿的价值高
                    dp[j] = Math.max(dp[j], dp[j-weight[i]] + value[i]);
                }
                // 如果j小于物品重量,那就不用动了,其实就是dp[i-1][j]相当于
            }
            System.out.println(Arrays.toString(dp));
        }
        System.out.println(dp[bagWeight]);
        return dp[bagWeight];
    }

    public static void main(String[] args) {
        Bag01 bag01 = new Bag01();
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        System.out.println(bag01.bag01V1(weight, value, 7));

    }
}
