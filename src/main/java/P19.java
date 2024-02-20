public class P19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 统计链表长度
        int len = 0;
        ListNode temp = head;
        while (temp != null) {
            len++;
            temp = temp.next;
        }

        if (n > len) {
            return null;
        }

        if (len == 1) {
            return null;
        }

        // len-n-1刚好找到要删除的元素的前一个
        ListNode before = head;
        for (int i = 0; i < len - n - 1; i++) {
            before = before.next;
        }
        if (len-n-1 < 0) {
            // 此时就是删除这个元素本身
            head = head.next;
        } else {
            before.next = before.next.next;
        }
        return head;
    }

    public static void main(String[] args) {
        P19 p19 = new P19();
        ListNode listNode = new ListNode(1);
//        ListNode listNode1 = new ListNode(2);
//        ListNode listNode2 = new ListNode(3);
//        listNode.next = listNode1;
//        listNode1.next = listNode2;
        ListNode listNode3 = p19.removeNthFromEnd(listNode, 1);
        while (listNode3 != null) {
            System.out.println(listNode3.val);
            listNode3 = listNode3.next;
        }
    }
}
