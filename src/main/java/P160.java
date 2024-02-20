//public class P160 {
//    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        ListNode temp;
//        ListNode tempb;
//        int lenA = 1;
//        int lenB = 1;
//        int sum = 0;
//        temp = headA.next;
//        while (temp != null) {
//            // 统计headA的长度
//            lenA++;
//            temp = temp.next;
//        }
//        temp = headB.next;
//        while (temp != null) {
//            // 统计headA的长度
//            lenB++;
//            temp = temp.next;
//        }
//
//        sum = lenA + lenB;
//        System.out.println(lenA);
//        System.out.println(lenB);
//
//        int minLen = Math.min(lenA, lenB);
//
//        if (lenA > lenB) {
//            temp = headA.next;
//            for (int i = 1; i < sum - minLen; i++) {
//                temp = temp.next;
//            }
//            tempb = headB.next;
//            for (int i = 0; i < minLen; i++) {
//                if (temp != null && tempb != null) {
//                    if (temp.val == tempb.val) {
//                        return temp;
//                    } else {
//                        temp = temp.next;
//                        tempb = tempb.next;
//                    }
//                }
//
//            }
//        } else {
//            temp = headB.next;
//            for (int i = 1; i < sum - minLen; i++) {
//                temp = temp.next;
//            }
//            tempb = headA.next;
//            for (int i = 0; i < minLen; i++) {
//                if (temp != null && tempb != null) {
//                    if (temp.val == tempb.val) {
//                        return temp;
//                    } else {
//                        temp = temp.next;
//                        tempb = tempb.next;
//                    }
//                }
//            }
//        }
//        return null;
//
//    }
//
//    public static void main(String[] args) {
//        P160 p160 = new P160();
//        ListNode listNode = new ListNode(4);
//        ListNode listNode1 = new ListNode(1);
//        ListNode listNode2 = new ListNode(8);
//        ListNode listNode3 = new ListNode(4);
//        ListNode listNode4 = new ListNode(5);
//        listNode.next = listNode1;
//        listNode1.next = listNode2;
//        listNode2.next = listNode3;
//        listNode3.next = listNode4;
//        ListNode listNode11 = new ListNode(5);
//        ListNode listNode12 = new ListNode(6);
//        ListNode listNode13 = new ListNode(1);
//        ListNode listNode14 = new ListNode(8);
//        ListNode listNode15 = new ListNode(4);
//        ListNode listNode16 = new ListNode(5);
//        listNode11.next = listNode12;
//        listNode12.next = listNode13;
//        listNode13.next = listNode14;
//        listNode14.next = listNode15;
//        listNode15.next = listNode16;
//        System.out.println(p160.getIntersectionNode(listNode, listNode11).val);
//    }
//}
//
//class ListNode1 {
//    int val;
//    ListNode next;
//
//    ListNode1(int x) {
//        val = x;
//        next = null;
//    }
//}