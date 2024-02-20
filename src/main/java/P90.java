import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P90 {
    List<List<Integer>> res = new ArrayList<>();

    List<Integer> path = new ArrayList<>();


    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        res.clear();
        path.clear();
        int[] used = new int[nums.length];
        backT(nums, used, 0);
        return res;
    }

    public void backT(int[] nums, int[] used, int startIndex) {
        res.add(new ArrayList<>(path));
        // 跳出的条件依然是遍历到叶子节点
        if (startIndex >= nums.length) return;

        for (int i = startIndex; i < nums.length; i++) {
            // 同样的使用层去重即可,也就是如果同一层的前一个元素和当前元素相同,那么就跳过
            // used[i-1]==0表示同一层,如果为1表示当前是下一层
            if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == 0) continue;
            path.add(nums[i]);
            used[i] = 1;
            backT(nums, used, i + 1);
            path.remove(path.size() - 1);
            used[i] = 0;
        }
    }

    public static void main(String[] args) {
        P90 p90 = new P90();
        int[] test = {4,4,4,1,4};
        System.out.println(p90.subsetsWithDup(test));
    }
}
