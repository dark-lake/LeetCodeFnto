public class P509 {
    public int fib(int n) {
        if(n==0) return 0;
        if(n==1) return 1;
        return fib(n-2) + fib(n-1);
    }

    public static void main(String[] args) {
        P509 p509 = new P509();
        System.out.println(p509.fib(3));
    }
}
