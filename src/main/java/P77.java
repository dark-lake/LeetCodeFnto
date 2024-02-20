import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class P77 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        res.clear();
        path.clear();
        backtracking(n, k, 1);
        return res;
    }

    public void backtracking(int n, int k, int startIndex) {
        if (path.size() == k) {
            List<Integer> tempRes = new ArrayList<>(path);
            res.add(tempRes);
            return;
        }

        for (int i = startIndex; i <= (n - (k-path.size()) + 1); i++) {
            // 当前i加入
            path.add(i);
            backtracking(n, k, i+1);
            path.remove(path.size()-1);
        }
    }

    public static void main(String[] args) {
        P77 p77 = new P77();
        System.out.println(p77.combine(4, 2));
    }
}
