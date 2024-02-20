public class P122 {
    public int maxProfit(int[] prices) {
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            int temp = prices[i] - prices[i-1];
            if(temp>0) res+=temp;
        }
        return res;
    }

    public static void main(String[] args) {
        P122 p122 = new P122();
        int[] test = {7,6,4,3,1};
        System.out.println(p122.maxProfit(test));
    }
}
