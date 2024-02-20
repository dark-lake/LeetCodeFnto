import java.util.List;

public class P0207FACE {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0, lenB = 0;
        ListNode a = headA, b = headB;
        // 计算它俩的长度
        while (a != null) {
            lenA++;
            a = a.next;
        }
        while (b != null) {
            lenB++;
            b = b.next;
        }
        // 从短的开始
        if (lenA > lenB) {
            for (int i = 0; i < lenA - lenB; i++) {
                if (headA != null) headA = headA.next;
            }
        } else {
            for (int i = 0; i < lenB - lenA; i++) {
                if (headB != null) headB = headB.next;
            }
        }
        // 此时长度一致了开始比较
        while (headA != null && headB != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }

    public static void main(String[] args) {
        P0207FACE p0207FACE = new P0207FACE();
        ListNode listNode0 = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode11 = new ListNode(2);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(4);
        ListNode listNode4 = new ListNode(5);
        listNode0.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
//        listNode11.next = listNode2;
        System.out.println(p0207FACE.getIntersectionNode(listNode0, listNode11).val);
    }
}
