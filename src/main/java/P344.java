public class P344 {
    public void reverseString(char[] s) {
        // 相向双指针
        int left = 0;
        int right = s.length-1;
        while(left < right){
            // 将left与right的值互换
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        P344 p344 = new P344();

    }
}
