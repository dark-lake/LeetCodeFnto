public class P28 {
    public int strStr(String haystack, String needle) {
        if(needle.length()>haystack.length()) return -1;
        char[] str1 = haystack.toCharArray();
        char[] str2 = needle.toCharArray();
        // j用来记录needle的指针,l用来记录开始匹配时的i,当匹配失败了的时候就让i重新回去的,要不然会出现
        // mississippi, issip的问题找不到的问题
        int j = 0,l = -1;
        for (int i = 0; i < str1.length; i++) {
            if (str1[i] == str2[j]) {
                if(l == -1) l = i;
                if (j == str2.length - 1) return i + 1 - str2.length;
                j++;
            } else {
                if (j != 0) {
                    j = 0;
                    i = l;
                    l = -1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        P28 p28 = new P28();
        System.out.println(p28.strStr("mississippi", "issip"));

    }
}
