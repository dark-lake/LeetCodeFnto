public class P134 {
    // 暴力法超时
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int tempGas;
        int k;
        for (int j = 0; j < gas.length; j++) {
            tempGas = gas[j] - cost[j];
            // 那就可以走了
            k = j;
            while (tempGas >= 0) {
                if (k > j && (k % gas.length) == j) return j;
                ++k;
                tempGas = tempGas + gas[k % gas.length] - cost[k % gas.length];
            }
            k = 0;
        }
        return -1;
    }

    public int canCompleteCircuit1(int[] gas, int[] cost) {
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < gas.length; i++) {
            sum += gas[i] - cost[i];
            if (sum < min) {
                min = sum;
            }
        }
        // 如果最小值大于等于0那就说明收入都大于支出
        if (min >= 0) return 0;
        // sum小于0,也就意味着花费要大于收入
        if (sum < 0) return -1;
        for (int i = gas.length - 1; i >= 0; i--) {
            min += gas[i] - cost[i];
            if (min >= 0) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        P134 p134 = new P134();
        int[] gas = {2,3,1};
        int[] cost = {3,1,2};
        System.out.println(p134.canCompleteCircuit1(gas, cost));
    }
}
