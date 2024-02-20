public class P24 {
    public ListNode swapPairs(ListNode head) {
        // 双指针
        ListNode t = head;
        if (t == null) return null;
        ListNode p = t.next;
        ListNode temp = t;
        while (p != null) {
            t.next = p.next;
            p.next = t;
            if (t == head) {
                // 说明此时是第一次交换
                head = p;
            } else {
                // 除了第一次其他的才需要更改temp,因为如果第一次也改的话会出现回头的情况
                temp.next = p;
                temp = t;
            }
            t = t.next;
            if (t == null) break;
            p = t.next;
        }
        return head;
    }

    public static void main(String[] args) {
        P24 p24 = new P24();
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(4);
        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        ListNode listNoden = p24.swapPairs(listNode);
        while (listNoden != null) {
            System.out.println(listNoden.val);
            listNoden = listNoden.next;
        }
    }
}
