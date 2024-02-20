public class P234 {
    public boolean isPalindrome(ListNode head) {
        int len = 0;
        ListNode temp = head;
        ListNode left;
        while (temp != null) {
            len++;
            temp = temp.next;
        }

        // 长度为1肯定是回文
        if (len == 1) return true;

        // 找到对称位置的元素给到left, 121就是2,1221就是第二个2
        temp = head;
        left = temp;
        for (int i = 0; i < len / 2; i++) {
            temp = temp.next;
            left = temp;
        }
        // 将后边的使用头插法
        temp = new ListNode(Integer.MIN_VALUE, null);
        for (int i = 0; i < (len / 2) + 1; i++) {
            if (left != null) {
                temp.next = new ListNode(left.val, temp.next);
                left = left.next;
            }
        }

        // 只需要比较head和temp的值是否相同即可
        temp = temp.next;
        for (int i = 0; i < (len / 2) + 1; i++) {
            if (temp != null && head != null) {
                if (temp.val != head.val) return false;
                temp = temp.next;
                head = head.next;
            }
        }

        return true;

    }

    public static void main(String[] args) {
        P234 p234 = new P234();
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(1);
//        ListNode listNode3 = new ListNode(1);
        listNode.next = listNode1;
        listNode1.next = listNode2;
//        listNode2.next = listNode3;
        boolean palindrome = p234.isPalindrome(listNode);
        System.out.println(palindrome);
//        System.out.println(3/2);
    }
}
