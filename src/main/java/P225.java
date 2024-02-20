import java.util.LinkedList;

public class P225 {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.top());
        System.out.println(myStack.top());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.empty());
    }
}

class MyStack {

    private final LinkedList<Integer> queue;
    private final LinkedList<Integer> tempQueue;

    public MyStack() {
        this.queue = new LinkedList<>();
        this.tempQueue = new LinkedList<>();
    }

    public void push(int x) {
        // 每次进来新的值都要将其前边的值都出队列
        while(!this.queue.isEmpty()){
            this.tempQueue.addLast(this.queue.pollFirst());
        }
        // x进队
        this.queue.addLast(x);
        // 再将tempQueue中的数据都进队
        while(!this.tempQueue.isEmpty()){
            this.queue.addLast(this.tempQueue.pollFirst());
        }
    }

    public Integer pop() {
        return this.queue.pollFirst();
    }

    public Integer top() {
        return this.queue.peekFirst();
    }

    public boolean empty() {
        return this.queue.isEmpty();
    }
}