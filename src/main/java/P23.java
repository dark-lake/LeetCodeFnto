public class P23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        if (lists.length < 2) {
            return lists[0];
        }

        ListNode k = null;

        for (int i = 0; i < lists.length - 1; i++) {
            if (i == 0){
                k = merge(lists[0], lists[1]);
                continue;
            }
            k = merge(k,lists[i+1]);
        }

        return k;
    }

    public ListNode merge(ListNode list1, ListNode second) {
        ListNode first = list1;
        list1 = new ListNode(Integer.MIN_VALUE, null);
        ListNode tail = list1;
        // 修改first即可
        while (first != null && second != null) {
            int f = first.val;
            int s = second.val;
            if (f <= s) {
                // list1 < list2 的值
                tail.next = first;
                tail = tail.next;

                first = first.next;
            } else {
                // list1 > list2 的值
                tail.next = second;
                tail = tail.next;

                second = second.next;
            }
        }
        if (first != null) tail.next = first;
        if (second != null) tail.next = second;

        return list1.next;
    }

    public static void main(String[] args) {
        P23 p23 = new P23();
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(3);
        ListNode listNode2 = new ListNode(5);
        ListNode listNode3 = new ListNode(7);
        ListNode listNode4 = new ListNode(8);
        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;

        ListNode listNode8 = new ListNode(1);
        ListNode listNode18 = new ListNode(3);
        ListNode listNode28 = new ListNode(6);
        ListNode listNode38 = new ListNode(7);
        ListNode listNode48 = new ListNode(9);
        listNode8.next = listNode18;
        listNode18.next = listNode28;
        listNode28.next = listNode38;
        listNode38.next = listNode48;

        ListNode listNode87 = new ListNode(6);
        ListNode listNode187 = new ListNode(7);
        ListNode listNode287 = new ListNode(8);
        ListNode listNode387 = new ListNode(9);
        listNode87.next = listNode187;
        listNode187.next = listNode287;
        listNode287.next = listNode387;

        ListNode[] test = {};
        ListNode listNode5 = p23.mergeKLists(test);
        while(listNode5!=null){
            System.out.println(listNode5.val);
            listNode5 = listNode5.next;
        }
    }
}
