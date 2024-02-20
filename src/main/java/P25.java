public class P25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        // 统计长度
        int len = 0;
        ListNode temp = head;
        ListNode temp1 = head;
        ListNode first = head;
        ListNode temp2;
        ListNode t = new ListNode(Integer.MIN_VALUE, null);
        while (temp != null) {
            len++;
            temp = temp.next;
        }

        int loopCount = len / k;

        for (int i = 0; i < loopCount; i++) {
            // 如果是每k个中的第一个就单独记录一下,因为它最后会变成最后一个,用于连接下一个子翻转链表
            temp2 = temp1;
            // 第一次
            for (int j = 0; j < k; j++) {
                // 头插法
                // temp 用来记录原本的节点的下一个节点,因为头插之后next就没了,所以要记录一下
                temp = temp1.next;
                // 这里使用头插法
                temp1.next = t.next;
                t.next = temp1;
                // 将temp1再置于要头插的下一个节点
                temp1 = temp;
            }
            if(i==0){
                head = t.next;
            }else{
                first.next = t.next;
                first = temp2;
            }
            t.next = null;
        }

        if(temp1!=null){
            // 也就是还有剩余
            first.next = temp1;
        }

        return head;
    }

    public static void main(String[] args) {
        P25 p25 = new P25();
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(4);
        ListNode listNode4 = new ListNode(5);
        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        ListNode ln = p25.reverseKGroup(listNode, 2);
        while(ln!=null){
            System.out.println(ln.val);
            ln = ln.next;
        }
    }
}
