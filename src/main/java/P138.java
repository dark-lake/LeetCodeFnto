import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P138 {
    public Node copyRandomList(Node head) {
        // 用一个list来保存深拷贝的每个节
        List<Node> nodes = new ArrayList<>();
        Map<Node,Integer> nodeIndex = new HashMap<>();
        // temp 用于第二次while
        Node temp = head;
        Node newHead = new Node(Integer.MIN_VALUE);
        Node tempNewHead;
        int count = 0;
        Node tail = newHead;
        // 第一次while用于深拷贝一个链表,不包括random
        while(head!=null){
            // 尾插法链接新链表保证顺序不变
            tail.next = new Node(head.val);
            tail = tail.next;
            // 将每个新节点放入到map中, 这样索引也保持不变了
            nodeIndex.put(head,count++);
            nodes.add(tail);
            head = head.next;
        }

        // 第二次while就是|设置对应的的random值
        // 获取copy后的第一个节点
        tempNewHead = newHead.next;
        while(temp!=null && tempNewHead!=null){
            Node random = temp.random;
            tempNewHead.random = random == null ? null : nodes.get(nodeIndex.get(random));
            temp = temp.next;
            tempNewHead = tempNewHead.next;
        }
        return newHead.next;
    }

    public static void main(String[] args) {
        P138 p138 = new P138();

    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
