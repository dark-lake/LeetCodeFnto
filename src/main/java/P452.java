import java.util.Arrays;
import java.util.Comparator;

public class P452 {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));
        int res = 0, s = points[0][1];
        for (int i = 1; i < points.length; i++) {
            s = Math.min(points[i][1], s);
            if(points[i][0] > s){
                res++;
                s = points[i][1];
            }
        }
        return res+1;
    }

    public static void main(String[] args) {
        P452 p452 = new P452();
        int[][] test = {{7,15},{6,14},{8,12},{3,4},{4,13},{6,14},{9,11},{6,12},{4,13}};
        System.out.println(p452.findMinArrowShots(test));
    }

}
