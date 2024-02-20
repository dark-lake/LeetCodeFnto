public class P860 {
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        for (int i = 0; i < bills.length; i++) {
            int temp = bills[i] - 5;
            if (temp == 0) {
                // 此时是5
                five++;
            } else if (temp == 5) {
                // 此时是10
                five--;
                ten++;
            } else {
                // 此时是20,如果10不够就用5
                if (ten == 0) {
                    five -= 3;
                } else {
                    ten--;
                    five--;
                }
            }
            if (five < 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        P860 p860 = new P860();
        int[] test = {5, 5, 10, 20, 5, 5, 5, 5, 5, 5, 5, 5, 5, 10, 5, 5, 20, 5, 20, 5};
        System.out.println(p860.lemonadeChange(test));
    }
}
