import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class P739 {
    public int[] dailyTemperatures(int[] temperatures) {
        // 需要一个两个栈,一个用来存放没有找到比他大的温度的值和其索引,一个用来存放结果
        Stack<Integer> data = new Stack<>();
        Stack<Integer> indexStack = new Stack<>();
        int[] index = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            // 先peek一下栈顶,如果栈顶值<当前值那么
            if(!data.isEmpty()){
                Integer peek = data.peek();
                Integer tempIndex = indexStack.peek();
                while(peek<temperatures[i]){
                    data.pop();
                    indexStack.pop();
                    index[tempIndex] = i - tempIndex;
                    // 此时处理栈中的下一个，有可能也比这个值小
                    // 此时这个值就相当于有了比他大的值了所以可以滚了
                    if(!data.isEmpty()){
                        peek = data.peek();
                        tempIndex = indexStack.peek();
                    }else{
                        break;
                    }
                }
                // 把这个数也入栈
                data.push(temperatures[i]);
                indexStack.push(i);
            }else{
                // 否则那就把这个数也入栈
                data.push(temperatures[i]);
                indexStack.push(i);
            }
        }

        for (Integer integer : indexStack) {
            index[integer] = 0;
        }

        return index;

    }

    public int[] dailyTemperatures1(int[] temperatures) {

        Deque<Integer> indexStack = new LinkedList<>();
        int[] index = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            while(!indexStack.isEmpty() && temperatures[indexStack.peek()] < temperatures[i]){
                Integer pop = indexStack.pop();
                index[pop] = i - pop;
            }
            indexStack.push(i);
        }

        return index;

    }

    public static void main(String[] args) {
        P739 p739 = new P739();
        int[] test = {73,74,75,71,69,72,76,73};
        int[] test1= {30,60,90};
        System.out.println(Arrays.toString(p739.dailyTemperatures1(test)));
    }
}
