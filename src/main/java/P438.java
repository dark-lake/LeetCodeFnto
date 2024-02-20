import java.lang.management.PlatformManagedObject;
import java.util.*;

public class P438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int sLen = s.length();
        int pLen = p.length();

        if(pLen>sLen){
            return res;
        }

        // 用于统计字母的个数
        int[] sStac = new int[26];
        int[] pStac = new int[26];

        // 统计第一个窗口,同时统计p中不同字母的个数
        for (int i = 0; i < pLen; i++) {
            sStac[s.charAt(i) - 'a']++;
            pStac[p.charAt(i) - 'a']++;
        }
        // 此时就可以判断第一个窗口是否是p的字母异位词
        if (Arrays.equals(sStac, pStac)) res.add(0);

        // 接着开始匹配剩下的窗口,一共还需要匹配sLen - pLen次
        for (int i = 0; i < sLen - pLen; i++) {
            // 这里只是统计不同字母的个数
            // 当前窗口的字母减去,可以理解为向右移动窗口
            sStac[s.charAt(i) - 'a']--;
            // 新增pLen位置后的字母
            sStac[s.charAt(i + pLen) - 'a']++;
            // 这里是i+1,因为i表示的是当前窗口,但是循环体执行完毕后得到的 sStac是下一个窗口的字母统计结果
            if(Arrays.equals(sStac, pStac)) res.add(i+1);
        }
        return res;
    }

    // 超时版本
    public List<Integer> findAnagrams1(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (p.length() > s.length()) {
            return res;
        }
        char[] pChar = p.toCharArray();
        Arrays.sort(pChar);
        p = String.valueOf(pChar);
        for (int i = p.length() - 1; i < s.toCharArray().length; i++) {
            String substring = s.substring((i + 1) - p.length(), i + 1);
            char[] chars = substring.toCharArray();
            Arrays.sort(chars);
            if (p.equals(String.valueOf(chars))) {
                res.add((i + 1) - p.length());
            }
        }
        return res;
    }

    public static void main(String[] args) {
        P438 p438 = new P438();

        System.out.println(p438.findAnagrams("abab", "ab"));
    }
}
