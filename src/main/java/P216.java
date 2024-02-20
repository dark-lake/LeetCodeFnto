import java.util.ArrayList;
import java.util.List;

public class P216 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    int sum = 0;

    public List<List<Integer>> combinationSum3(int k, int n) {
        res.clear();
        path.clear();
        backTraceing(n, k, 0, 1);
        return res;
    }

    public void backTraceing(int targetSum, int k, int sum, int s) {
        if (path.size() == k) {
            if (sum == targetSum) {
                List<Integer> temp = new ArrayList<>(path);
                res.add(temp);
            }
            return;
        }

        for (int i = s; i <= 9; i++) {
            sum += i;
            path.add(i);
            backTraceing(targetSum, k, sum, i + 1);
            path.remove(path.size() - 1);
            sum -= i;
        }
    }

    public List<List<Integer>> combinationSum4(int k, int n) {
        res.clear();
        path.clear();
        backTraceing1(n, k, 1);
        return res;
    }

    public void backTraceing1(int n, int k, int s) {
        if (path.size() == k) {
            if (sum == n) {
                List<Integer> temp = new ArrayList<>(path);
                res.add(temp);
            }
            return;
        }

        for (int i = s; i <= (9 - (k - path.size()) + 1); i++) {
            sum += i;
            path.add(i);
            if (sum > n) {
                sum -= i;
                path.remove(path.size() - 1);
                return;
            }
            backTraceing(n, k, sum, s + 1);
            path.remove(path.size() - 1);
            sum -= i;
        }
    }

    public static void main(String[] args) {
        P216 p216 = new P216();
        System.out.println(p216.combinationSum4(3, 7));
    }
}
