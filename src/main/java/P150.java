import java.util.LinkedList;

public class P150 {
    public int evalRPN(String[] tokens) {
        LinkedList<Integer> nums = new LinkedList<>();
        for (int i = 0; i < tokens.length; i++) {
            if (!tokens[i].equals("+")
                    && !tokens[i].equals("-")
                    && !tokens[i].equals("*")
                    && !tokens[i].equals("/")) {
                // 此时它就是一个数字,进入nums栈中
                nums.push(Integer.parseInt(tokens[i]));
            }else{
                // 那就是符号
                // 栈顶
                int first = nums.pop();
                // 第二个
                int second = nums.pop();
                if(tokens[i].equals("+")) nums.push(second + first);
                if(tokens[i].equals("-")) nums.push(second - first);
                if(tokens[i].equals("*")) nums.push(second * first);
                if(tokens[i].equals("/")) nums.push(second / first);
            }
        }
        return nums.pop();
    }

    public static void main(String[] args) {
        P150 p150 = new P150();
        String[] test = {"1", "2","+","3","4","*", "-"};
        System.out.println(p150.evalRPN(test));
    }
}
