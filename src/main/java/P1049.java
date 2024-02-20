import java.util.Arrays;

public class P1049 {
    public int lastStoneWeightII(int[] stones) {
        if(stones.length == 1) return stones[0];
        // 求和，然后背包容量相当于sum/2
        // 思路: 你可以理解为我们最后要的石头的重量最小那么这两个石头的重量应该无限接近最好,这样结果最小
        // 那么就可以去算一下是不是有sum/2(向下取整)的石头容量,如果有那么最后结果就是 (sum-target) - target,
        int sum = 0;
        // 都是正整数
        for (int stone : stones) sum += stone;
        // dp数组,你可以理解为从里面找到n个可以组成sum/2的石头不,无论找不着的到dp[-1]都是target
        int[] dp = new int[sum/2 + 1];

        // 这里初始化也就是填入第一个石头
        for (int i = 0; i < dp.length; i++) {
            dp[i] = i >= stones[0] ? stones[0] : 0;
        }
//        System.out.println(Arrays.toString(dp));
        // 从第二个物品开始遍历
        for (int i = 1; i < stones.length; i++) {
            for (int j = sum / 2; j >= stones[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j-stones[i]] + stones[i]);
            }
//            System.out.println(Arrays.toString(dp));
        }

        return (sum - dp[sum/2]) - dp[sum/2];
    }

    public static void main(String[] args) {
        P1049 p1049 = new P1049();
        int[] tset = {31,26,33,21,40};
        System.out.println(p1049.lastStoneWeightII(tset));
    }
}
