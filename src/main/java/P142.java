import java.util.HashMap;
import java.util.Map;

public class P142 {
    public ListNode detectCycle(ListNode head) {
        // 元素地址和其索引
        Map<ListNode, Integer> res = new HashMap<>();
        // 这个是为了当head只有一个元素的时候
        int count = 0;
        while (head != null) {
            Integer integer = res.get(head.next);
            // 有环
            if(integer!=null){
                // System.out.println(integer);
                return head.next;
            }else{
                // 放入res中
                res.put(head, count++);
            }
            head = head.next;
        }
        // 没有环
        return null;
    }
}
