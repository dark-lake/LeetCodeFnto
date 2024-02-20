import java.util.*;

public class P135 {
    public int candy(int[] ratings) {
        // 通过一个map来记录从小到大的每个值的索引
        int[] temp = new int[ratings.length];
        Map<Integer, List<Integer>> table = new TreeMap<>();
        for (int i = 0; i < ratings.length; i++) {
            List<Integer> tempList = table.getOrDefault(ratings[i], new ArrayList<>());
            tempList.add(i);
            table.put(ratings[i], table.getOrDefault(ratings[i], tempList));
        }
        System.out.println(table);
        for (Integer integer : table.keySet()) {
            List<Integer> indexList = table.get(integer);
            if (integer == 0) {
                for (Integer i : indexList) {
                    temp[i] = 1;
                }
            } else {
                for (Integer i : indexList) {
                    if (i == 0) {
                        if (ratings[i] > ratings[i + 1]) {
                            temp[i] = temp[i + 1] + 1;
                        } else if (ratings[i] == ratings[i + 1]) {
                            temp[i] = temp[i + 1];
                        } else {
                            temp[i] = 1;
                        }
                    } else if (i == ratings.length - 1) {
                        if (ratings[i] > ratings[i - 1]) {
                            temp[i] = temp[i - 1] + 1;
                        } else if (ratings[i] == ratings[i - 1]) {
                            temp[i] = temp[i - 1];
                        } else {
                            temp[i] = 1;
                        }
                    } else {
                        // 判断其左右
                        if (ratings[i] > ratings[i - 1] && ratings[i] > ratings[i + 1]) {
                            // 比两边的都大,那就让两边里面大的那个加1即可
                            temp[i] = Math.max(temp[i - 1], temp[i + 1]) + 1;
                        }
                        if (ratings[i] >= ratings[i - 1] && ratings[i] < ratings[i + 1]) {
                            // 一大一小,就用小的加一
                            temp[i] = ratings[i] == ratings[i - 1] ? temp[i - 1] : temp[i - 1] + 1;
                        }
                        if (ratings[i] < ratings[i - 1] && ratings[i] >= ratings[i + 1]) {
                            temp[i] = ratings[i] == ratings[i + 1] ? temp[i + 1] : temp[i + 1] + 1;
                        }
                        if (ratings[i] < ratings[i - 1] && ratings[i] < ratings[i + 1]) {
                            temp[i] = 1;
                        }
                    }
                }
            }
        }
        int sum = 0;
        for (int i : temp) {
            sum += i;
        }
        return sum;

    }

    public int test(int[] ratings) {
        int[] res = new int[ratings.length];
        Arrays.fill(res, 1);
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                res[i] = res[i - 1] + 1;
            }
        }
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                res[i] = Math.max(res[i], res[i + 1] + 1);
            }
        }
        int sum = 0;
        for (int re : res) {
            sum += re;
        }
        return sum;
    }

    public static void main(String[] args) {
        P135 p135 = new P135();
        int[] test = {1, 2, 2};
        System.out.println(p135.test(test));
    }
}
