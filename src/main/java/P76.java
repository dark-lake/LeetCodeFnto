import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class P76 {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) return "";
        int i = 0;
        String res = "";
        Map<Character, Integer> table = new HashMap<>();
        // table1是标准
        Map<Character, Integer> table1 = new HashMap<>();
        for (char c : t.toCharArray()) {
            table.put(c, 0);
            table1.put(c, table1.getOrDefault(c, 0) + 1);
        }
//        System.out.println(table);
//        System.out.println(table1);
        for (int j = 0; j < s.toCharArray().length; j++) {
            char c = s.charAt(j);
            // 当遇到这个里面的值的时候才加1
            if (table.containsKey(c)) {
                table.put(c, table.get(c) + 1);
            }
            // 也就是当子串长度大于等于t.length()的时候就判断这个子串是不是符合要求了
            if (j - i + 1 >= t.length()) {
                // 判断是不是满足和标准结果一样, 这里应该是table的value都大于table1的value就OK
                while (ok(table, table1)) {
                    // 重新覆盖res, 如果新的子串更短那就用新的
                    if (!res.equals("")) {
                        if (j - i + 1 <= res.length()) res = s.substring(i, j + 1);
                    } else {
                        res = s.substring(i, j + 1);
                    }
                    // 此时说明满足了,i++,并且table中i对应的值-1
                    if (table.containsKey(s.charAt(i))) {
                        table.put(s.charAt(i), table.get(s.charAt(i)) - 1);
                    }
                    i++;
                }
            }
        }
        return res;
    }

    public boolean ok(Map<Character, Integer> table, Map<Character, Integer> table1) {
        boolean res = true;
        for (Character character : table1.keySet()) {
            if (table.get(character) < table1.get(character)) res = false;
        }
        return res;
    }


    public static void main(String[] args) {
        P76 p76 = new P76();
        System.out.println(p76.minWindow("ADOBECODEBANC", "ABC"));
    }
}
