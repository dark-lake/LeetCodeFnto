import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P131 {

    List<List<String>> res = new ArrayList<>();

    List<String> path = new ArrayList<>();

    public List<List<String>> partition(String s) {
        res.clear();
        path.clear();
        backT(s, 0);
        return res;
    }

    public void backT(String s, int startIndex) {
        if (startIndex >= s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }
        char[] chars = s.toCharArray();
        for (int i = startIndex; i < chars.length; i++) {
            if (isOk(s.substring(startIndex, i+1))) {
                // 获取子串
                path.add(s.substring(startIndex, i+1));
            } else {
                continue;
            }
            backT(s, i + 1);
            path.remove(path.size() - 1);
        }
    }

    public boolean isOk(String s) {
        char[] chars = s.toCharArray();
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (chars[left++] != chars[right--]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        P131 p131 = new P131();
        System.out.println(p131.partition("aab"));
//        System.out.println(p131.isOk("abc"));
    }
}
