import java.util.Arrays;

public class P518 {
    public int change(int amount, int[] coins) {
        // 完全背包 求刚好凑满某个背包容量的不同组合数
        // 01背包中有类似的题目
        int[] dp = new int[amount + 1];
        // 这种求组合数的初始化第一个一定是1,因为比如此时的物品重量为3,背包容量也为3,那么dp[j-weight]是dp[0]了
        // 逻辑上这个物品就可以凑满3了,所以dp[0]初始化需要为1
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j < dp.length; j++) {
                // 比如说能凑满2的有2种组合,但是凑满3有0中组合,此时这个硬币是1
                // 那么凑好三是不是可以用原来就可以凑好3的组合数再加上,凑满2的组合数 + 这个硬币 刚好等于3
                // 这样就是刚好凑满3的组合数
                dp[j] += dp[j-coins[i]];
            }
            System.out.println(Arrays.toString(dp));
        }
        return dp[amount];
    }

    public int change1(int amount, int[] coins) {
        // 完全背包 求刚好凑满某个背包容量的不同组合数
        // 01背包中有类似的题目
        int[] dp = new int[amount + 1];
        // 这种求组合数的初始化第一个一定是1,因为比如此时的物品重量为3,背包容量也为3,那么dp[j-weight]是dp[0]了
        // 逻辑上这个物品就可以凑满3了,所以dp[0]初始化需要为1
        dp[0] = 1;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < coins.length; j++) {
                if(i >= coins[j]) dp[i] += dp[i-coins[j]];
            }
            System.out.println(Arrays.toString(dp));
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        P518 p518 = new P518();
//        System.out.println(p518.change(5, new int[]{1, 2, 5}));
        System.out.println("-----------------");
        System.out.println(p518.change1(2, new int[]{1, 1, 1}));
    }
}
