import java.util.*;

public class P148 {
    public ListNode sortList(ListNode head) {
        Map<Integer, List<ListNode>> nodeIndexMapper = new HashMap<>();
        List<Integer> sortList = new ArrayList<>();
        ListNode temp = head;
        // 填充nodeIndexMapper
        while(temp!=null){
            List<ListNode> eachNode = nodeIndexMapper.getOrDefault(temp.val, new ArrayList<>());
            eachNode.add(temp);
            nodeIndexMapper.put(temp.val,eachNode);
            sortList.add(temp.val);
            temp = temp.next;
        }
        head = new ListNode(Integer.MIN_VALUE, null);
        temp = head;
        // 对sortList排序
        Integer[] integers = sortList.toArray(new Integer[0]);
        Arrays.sort(integers);
        for (Integer integer : integers) {
            List<ListNode> listNodes = nodeIndexMapper.get(integer);
            for (ListNode listNode : listNodes) {
                listNode.next = null;
                temp.next = listNode;
                temp = temp.next;
            }
            nodeIndexMapper.put(integer,new ArrayList<>());
        }
        return head.next;
    }

    public static void main(String[] args) {
        P148 p148 = new P148();
        ListNode listNode = new ListNode(5);
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(2);
        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        ListNode listNode5 = p148.sortList(listNode);
        while(listNode5!=null){
            System.out.println(listNode5.val);
            listNode5 = listNode5.next;
        }
    }
}
