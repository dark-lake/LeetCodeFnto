import java.sql.Array;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Stack;

public class P155 {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}

class MinStack {

    Stack<Integer> data;

    // 我要一个东西用来存栈中每个值的从小到大的索引
    Stack<Integer> minStack;

    MinStack() {
        this.data = new Stack<>();
        this.minStack = new Stack<>();
    }

    public void push(int val) {
        if (!this.minStack.isEmpty()) {
            int min = this.minStack.peek();
            if (min >= val) {
                this.minStack.push(val);
            }
        }else{
            this.minStack.push(val);
        }
        this.data.push(val);
    }

    public void pop() {
        if (!this.data.isEmpty()) {
            int min = this.minStack.peek();
            Integer pop = this.data.pop();
            if (min == pop) {
                this.minStack.pop();
            }
        }
    }

    public Integer top() {
        if (!this.data.isEmpty()) {
            return this.data.peek();
        }
        return null;
    }

    public Integer getMin() {
        if (!this.minStack.isEmpty()) {
            return this.minStack.peek();
        }
        return null;
    }

}

