import java.util.List;

public class P206 {
    public ListNode reverseList(ListNode head) {
        ListNode res = new ListNode(Integer.MIN_VALUE, null);
        while(head!=null){
            res.next = new ListNode(head.val, res.next);
            head = head.next;
        }
        return  res.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(4);
        ListNode listNode4 = new ListNode(5);
        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
//        while(listNode!=null){
//            System.out.println(listNode.val);
//            listNode = listNode.next;
//        }
        P206 p206 = new P206();
        ListNode listNode5 = p206.reverseList(listNode);
        while(listNode5!=null){
            System.out.println(listNode5.val);
            listNode5 = listNode5.next;
        }
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}