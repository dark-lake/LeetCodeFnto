import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class P39 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        res.clear();
        path.clear();
        backT(candidates, target, 0, 0);
        return res;
    }

    public void backT(int[] candidates, int target, int sum, int startIndex) {
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {
            if(sum+candidates[i]>target) return;
            sum += candidates[i];
            path.add(candidates[i]);
            backT(candidates, target, sum, i);
            sum -= candidates[i];
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        P39 p39 = new P39();
        int[] test = {2, 3, 6, 7};
        System.out.println(p39.combinationSum(test, 7));
    }
}
