public class P2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode res = new ListNode(Integer.MIN_VALUE, null);
        ListNode tail = res;
        int add1 = 0;
        while (l1 != null && l2 != null) {
            ListNode temp = new ListNode();
            // 获得和
            int temp_val = l1.val + l2.val + add1;
            // 获得进1的余数
            // 填充temp
            temp.val = temp_val % 10;
            // 尾插法
            if (res.next == null) {
                res.next = temp;
            } else {
                tail.next = temp;
            }
            tail = temp;
            // 判断是否需要进1
            add1 = temp_val >= 10 ? 1 : 0;
            l1 = l1.next;
            l2 = l2.next;
        }


        // 短的加完了
        if (l1 != null) {
            if (add1 == 1) {
                // 此时需要给l1加1, 用temp1来记录l1的开头
                ListNode temp1 = l1;
                while (l1 != null) {
                    int i = l1.val + add1;
                    if (i >= 10) {
                        l1.val = i % 10;
                    } else {
                        l1.val = i;
                        add1 = 0;
                        break;
                    }
                    l1 = l1.next;
                }
                tail.next = temp1;
            } else {
                tail.next = l1;
            }
        }
        // 短的加完了
        if (l2 != null) {
            if (add1 == 1) {
                // 此时需要给l1加1, 用temp1来记录l1的开头
                ListNode temp1 = l2;
                while (l2 != null) {
                    int i = l2.val + add1;
                    if (i >= 10) {
                        l2.val = i % 10;
                    } else {
                        l2.val = i;
                        add1 = 0;
                        break;
                    }
                    l2 = l2.next;
                }
                tail.next = temp1;
            } else {
                tail.next = l2;
            }
        }


        if (add1 == 1) {
            ListNode listNode = new ListNode(add1, null);
            while (tail.next != null) {
                tail = tail.next;
            }
            tail.next = listNode;
        }

        return res.next;
    }

    public static void main(String[] args) {
        P2 p2 = new P2();
        ListNode listNode = new ListNode(9);
        ListNode listNode1 = new ListNode(9);
        ListNode listNode2 = new ListNode(3);
        listNode.next = listNode1;
        listNode1.next = listNode2;

        ListNode listNode01 = new ListNode(9);
        ListNode listNode11 = new ListNode(9);
        listNode01.next = listNode11;
        ListNode listNode4 = p2.addTwoNumbers(listNode, listNode01);
        while (listNode4 != null) {
            System.out.println(listNode4.val);
            listNode4 = listNode4.next;
        }
    }
}
