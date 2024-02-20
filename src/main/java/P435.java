import java.util.Arrays;
import java.util.Comparator;

public class P435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        int res = 0;
        // 第一个元素按照升序,第二个元素按照升序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int min = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] >= min) {
                // 此时无重叠
                min = intervals[i][1];
            }else{
                // 此时重叠了
                min = Math.min(min, intervals[i][1]);
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        P435 p435 = new P435();
        int[][] test = {{1,2},{2,3},{3,4},{1,3}};
        int[][] test1 = {{1,2},{1,2},{1,2}};
        int[][] test2 = {{1,3},{2,5},{3,7},{4,9}};
        System.out.println(p435.eraseOverlapIntervals(test2));
    }
}
