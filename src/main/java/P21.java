public class P21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 将list1空出来用作最后结果
        ListNode temp = list1;
        ListNode tail = null;
        list1 = null;
        while (temp != null && list2 != null) {
            if (temp.val >= list2.val) {
                if (list1 == null) {
                    list1 = list2;
                    tail = list2;
                } else {
                    tail.next = list2;
                    tail = tail.next;
                }

                // 谁小谁往后走
                list2 = list2.next;
            } else {
                if (list1 == null) {
                    list1 = temp;
                    tail = list1;
                } else {
                    tail.next = temp;
                    tail = tail.next;
                }

                // 谁小谁往后走
                temp = temp.next;
            }
        }

        // 此时temp或者list2还有一个有剩余,拼接到tail的末尾

        if (temp != null) {
            if (tail != null) {
                tail.next = temp;
            } else {
                list1 = temp;
            }
        } else {
            if (tail != null) {
                tail.next = list2;
            } else {
                list1 = list2;
            }
        }

        return list1;

    }

    public static void main(String[] args) {
        P21 p21 = new P21();
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(4);
        listNode.next = listNode1;
//        listNode1.next = listNode2;
        listNode2.next = listNode3;
        ListNode listNode4 = p21.mergeTwoLists(listNode, listNode2);
        while (listNode4 != null) {
            System.out.println(listNode4.val);
            listNode4 = listNode4.next;
        }
    }
}
