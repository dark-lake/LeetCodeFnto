import javax.print.attribute.standard.PrinterURI;

public class P541 {
    public String reverseStr(String s, int k) {
        char[] str = s.toCharArray();
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if ((i + 1) % (k * 2) == 0) {
                // 此时翻转前k个, 前k个的末尾就是left+k-1
                swap(str, left, left + k - 1);
                left = i + 1;
            } else if ((i + 1) % (k * 2) > 0 && i == str.length - 1) {
                // 此时就是最后的那部分
                if (i - left + 1 >= k){
                    // 翻转前k个
                    swap(str, left, left + k -1);
                }else{
                    swap(str, left, i);
                }
            }
        }
        return new String(str);
    }

    public void swap(char[] str, int left, int right) {
        while (left <= right) {
            char temp = str[left];
            str[left] = str[right];
            str[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        P541 p541 = new P541();
        System.out.println(p541.reverseStr("12", 2));
    }
}
