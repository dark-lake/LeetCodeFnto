public class P1137 {
    /**
     * 递归超时
     */
    public int tribonacci(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;
        return tribonacci(n - 3) + tribonacci(n - 2) + tribonacci(n - 1);
    }

    public int tribonacciFor(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;
        int a = 0, b = 1, c = 1, temp = 0;
        for (int i = 3; i <= n; i++) {
            temp = a+b+c;
            a = b;
            b = c;
            c = temp;
        }
        return c;
    }

    public static void main(String[] args) {
        P1137 p1137 = new P1137();
        System.out.println(p1137.tribonacciFor(3));
    }
}
