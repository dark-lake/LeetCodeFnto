import java.util.Arrays;

public class P59 {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int startx = 0;
        int starty = 0;
        int loop = n / 2;
        int mid = n / 2;
        int count = 1;
        int offset = 1;
        int i, j;
        while (loop-- > 0) {

            // 从左到右
            for (j = starty; j < n - offset; j++) res[startx][j] = count++;
            // 从上到下
            for (i = startx; i < n - offset; i++) res[i][j] = count++;
            // 从右到左
            for (; j > starty; j--) res[i][j] = count++;
            // 从下到上
            for (; i > startx; i--) res[i][j] = count++;

            startx++;
            starty++;
            offset++;

        }
        if (n % 2 == 1) res[mid][mid] = n * n;

        return res;
    }

    public static void main(String[] args) {
        P59 p59 = new P59();
        int[][] ints = p59.generateMatrix(10);
        for (int[] anInt : ints) {
            System.out.println(Arrays.toString(anInt));
        }
    }
}
