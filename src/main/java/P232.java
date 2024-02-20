import java.util.LinkedList;

public class P232 {
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        System.out.println(myQueue.peek());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.empty());

    }
}

class MyQueue {
    private final LinkedList<Integer> inStack;
    private final LinkedList<Integer> outStack;

    public MyQueue() {
        this.inStack = new LinkedList<>();
        this.outStack = new LinkedList<>();
    }

    public void push(int x) {
        this.inStack.push(x);
    }

    public Integer pop() {
        // 出栈
        if(!outStack.isEmpty()){
            return outStack.pop();
        }else{
            // 如果出对的栈中没有值,那么就将instack中的值都加入到outStack
            if(!inStack.isEmpty()) {
                for (Integer integer : this.inStack) {
                    this.outStack.push(integer);
                }
                this.inStack.clear();
                return outStack.pop();
            }else{
                return null;
            }
        }
    }

    public Integer peek() {
        if(!outStack.isEmpty()){
            return outStack.peek();
        }else{
            // 如果出对的栈中没有值,那么就将instack中的值都加入到outStack
            if(!inStack.isEmpty()) {
                for (Integer integer : this.inStack) {
                    this.outStack.push(integer);
                }
                this.inStack.clear();
                return outStack.peek();
            }else{
                return null;
            }
        }
    }

    public boolean empty() {
        return this.inStack.isEmpty() && this.outStack.isEmpty();
    }
}