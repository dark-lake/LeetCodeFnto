import java.util.*;

public class P763 {
    public List<Integer> partitionLabels(String s) {
//        Map<Character, Integer> table = new HashMap<>();
        int[] table = new int[26];
        // 拿到每一个元素的在s中的最后一个位置
        for (int i = 0; i < s.toCharArray().length; i++) {
//            table.put(s.charAt(i), Math.max(table.getOrDefault(s.charAt(i), -1), i));
            table[s.charAt(i) - 'a'] = i;
        }
        List<Integer> res = new LinkedList<>();
        int tempRes = 1;
        int l = 0;
        for (int i = 0; i < s.toCharArray().length; i++) {
            l = Math.max(l, table[s.charAt(i) - 'a']);
            if(i==l){
                // 此时某一个子串走到末尾了
                res.add(tempRes);
                tempRes = 1;
            }else{
                // 此时还没走到,那就让tempRes++
                tempRes++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        P763 p763 = new P763();
        System.out.println(p763.partitionLabels("eccbbbbdec"));
    }
}
