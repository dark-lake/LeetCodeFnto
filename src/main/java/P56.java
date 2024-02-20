import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 合并区间
 */
public class P56 {
    /**
     * 判断任意两个数组, 因为是升序的
     * [i,x], [y,j] 若 y>x则重叠 合并为[i,j]
     *
     * @param intervals
     * @return
     */
    public static int[][] merge(int[][] intervals) {
        // 排序
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
        System.out.println(Arrays.deepToString(intervals));
        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);
        for (int i = 0; i < intervals.length; i++) {
            int[] ints = res.get(res.size()-1);
            if (intervals[i][0] > ints[1]) {
                // 此时肯定没有交集
                res.add(intervals[i]);
            } else {
                // 否则的话说明它俩有重叠，那么就修改
                ints[1] = Math.max(ints[1], intervals[i][1]);
            }
        }
        int[][] result = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] test_data = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        System.out.println(Arrays.deepToString(merge(test_data)));
    }
}
