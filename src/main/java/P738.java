public class P738 {
    public int monotoneIncreasingDigits(int n) {
        // 从后往前推
        int nine = Integer.MAX_VALUE;
        char[] s = String.valueOf(n).toCharArray();
        for (int i = s.length - 1; i > 0; i--) {
            if(s[i-1] > s[i]){
                nine = i;
                // 此时是前边大于后边了, 前边减一,后边变成9
                int t = Integer.parseInt(String.valueOf(s[i-1]));
                s[i-1] = (char)((t-1) + '0');
            }
        }
        for(int i=nine;i<s.length;i++){
            s[i] = '9';
        }
        return Integer.parseInt(String.valueOf(s));
    }

    public static void main(String[] args) {
        P738 p738 = new P738();
        System.out.println(p738.monotoneIncreasingDigits(10));
    }
}
