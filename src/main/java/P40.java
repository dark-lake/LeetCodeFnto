import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P40 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    int[] used;
    int sum = 0;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // 首先一定要排序,可以让相同的元素挨着,方便判断是否使用过
        Arrays.sort(candidates);
        // used数组表示某个元素是否使用过
        // 0表示正在使用(层结构)
        // 1(树枝结构),当它为1的时候
        used = new int[candidates.length];
        res.clear();
        path.clear();
        backT(candidates, target, 0);
        return res;
    }

    public void backT(int[] candidates, int target, int startIndex) {
        if (target == sum) {
            res.add(new ArrayList<>(path));
            return;
        }
        // sum+can[i]<=target这是基本的减枝操作
        for (int i = startIndex; i < candidates.length && sum + candidates[i] <= target; i++) {
            // i>0是要防止i-1为-1
            // can[i]==can[i-1]说明当前元素和前一个元素相同
            // used[i-1]==0说明前一个元素的树枝层已经全部处理完毕了,那么就可以跳过当前的元素了
            // 因为当前元素和它相同,再上一个元素的树枝层已经处理过
            if (i > 0 && candidates[i] == candidates[i - 1] && used[i - 1] == 0) continue;
            used[i] = 1;
            sum += candidates[i];
            path.add(candidates[i]);
            backT(candidates, target, i + 1);
            sum -= candidates[i];
            used[i] = 0;
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        P40 p40 = new P40();
        int[] test = {2, 5, 2, 1, 2};
        System.out.println(p40.combinationSum2(test, 5));
    }
}
