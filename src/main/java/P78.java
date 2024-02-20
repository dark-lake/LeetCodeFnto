import java.util.ArrayList;
import java.util.List;

public class P78 {
    List<List<Integer>> res = new ArrayList<>();

    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        res.clear();
        path.clear();
        backT(nums, 0);
        return res;
    }

    public void backT(int[] nums, int startIndex) {
        res.add(new ArrayList<>(path));
        if(startIndex>=nums.length) return;

        for (int i = startIndex; i < nums.length; i++) {
            path.add(nums[i]);
            backT(nums, i + 1);
            path.remove(path.size()-1);
        }
    }

    public static void main(String[] args) {
        P78 p78 = new P78();
        int[] test = {1,2,3};
        System.out.println(p78.subsets(test));
    }
}
