import javax.imageio.plugins.jpeg.JPEGImageReadParam;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class P406 {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);

        LinkedList<int[]> list = new LinkedList<>();
        for (int[] i : people) {
            list.add(i[1], i);
        }

        return list.toArray(people);
    }

    public static void main(String[] args) {
        P406 p406 = new P406();
        int[][] test = {
                {7, 0},
                {4, 4},
                {7, 1},
                {5, 0},
                {6, 1},
                {5, 2}
        };
        System.out.println(Arrays.deepToString(p406.reconstructQueue(test)));
    }
}
