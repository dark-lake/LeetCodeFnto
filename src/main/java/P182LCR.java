public class P182LCR {
    public String dynamicPassword(String password, int target) {
        char[] str = password.toCharArray();
        char[] frontK = new char[target];
        for (int i = 0; i < str.length; i++) {
            if (i < target) {
                frontK[i] = str[i];
            } else {
                str[i - target] = str[i];
            }
        }
        for(int i=str.length-target, k=0;i<str.length;i++,k++){
            str[i] = frontK[k];
        }
        return new String(str);
    }
    public String dynamicPassword1(String password, int target) {
        StringBuilder sb = new StringBuilder();
        String sb1 = password.substring(0, target);
        String sb2 = password.substring(target);
        sb.append(sb2).append(sb1);
        return sb.toString();
    }

    public String dynamicPassword2(String password, int target) {
        char[] str = password.toCharArray();
        swap(str, 0, target-1);
        swap(str, target, str.length-1);
        swap(str, 0, str.length-1);
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
        P182LCR p182LCR = new P182LCR();
        System.out.println(p182LCR.dynamicPassword2("12345", 2));
    }

}
