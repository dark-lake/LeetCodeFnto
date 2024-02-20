import java.util.Deque;
import java.util.LinkedList;

public class P84 {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> maxStack = new LinkedList<>();
        int max = 0;
        for (int height : heights) {
            int temp_max = 1;
            while(!maxStack.isEmpty()){

            }
            max = Math.max(temp_max, max);
        }
        return 0;
    }

    public static void main(String[] args) {
        P84 p84 = new P84();

//        System.out.println(p84.largestRectangleArea());
    }
}
