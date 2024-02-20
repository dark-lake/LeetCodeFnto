import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P17 {
    List<String> res = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    String[] str = {
            "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        res.clear();
        backT(digits.length(),digits,0);
        return res;
    }

    public void backT(int k, String n, int startIndex) {
        if (sb.length() == k && !sb.toString().equals("")) {
            res.add(sb.toString());
            return;
        }
        if(startIndex==n.length()) return;
        int c = Integer.parseInt(String.valueOf(n.charAt(startIndex)));
        char[] chars = str[c].toCharArray();
        for (char aChar : chars) {
            sb.append(aChar);
            backT(k, n, startIndex + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        P17 p17 = new P17();
        System.out.println(p17.letterCombinations(""));
    }
}
