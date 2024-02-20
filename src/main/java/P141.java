import java.util.HashMap;
import java.util.Map;

public class P141 {
    public boolean hasCycle(ListNode head) {
        // 元素地址和其索引
        Map<ListNode, Integer> res = new HashMap<>();
        // 这个是为了当head只有一个元素的时候
        int count = 0;
        while (head != null) {
            Integer integer = res.get(head.next);
            // 有环
            if(integer!=null){
                // System.out.println(integer);
                return true;
            }else{
                // 放入res中
                res.put(head, count++);
            }
            head = head.next;
        }
        // 没有环
        return false;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(1);
        ListNode listNode3 = new ListNode(1);
        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        P141 p141 = new P141();
        boolean b = p141.hasCycle(listNode);
        System.out.println(b);
    }
}
