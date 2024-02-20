import java.util.*;

public class P347 {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(k,
                new Comparator<>() {
                    @Override
                    public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                        return o1.getValue() - o2.getValue();
                    }
                }
        );
        Map<Integer, Integer> table = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            table.put(nums[i], table.getOrDefault(nums[i], 0) + 1);
        }
        int count = 0;
        for (Map.Entry<Integer, Integer> entry : table.entrySet()) {
            if (count < k) {
                pq.offer(entry);
            }else if(!pq.isEmpty() && entry.getValue() > pq.peek().getValue()){
                pq.poll();
                pq.offer(entry);
            }
            count++;
        }

        int[] res = new int[pq.size()];
        for (int i = 0; i < res.length; i++) {
            if(!pq.isEmpty()) res[i] = pq.poll().getKey();
        }
        return res;
    }

    public static void main(String[] args) {
        P347 p347 = new P347();
        int[] test = {1,1,1,2,2,3};
        System.out.println(Arrays.toString(p347.topKFrequent(test, 2)));
    }
}
