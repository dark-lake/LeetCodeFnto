import java.util.Stack;

public class P394 {
    public String decodeString(String s) {
        Stack<String> charStack = new Stack<>();
        Stack<Integer> countStack = new Stack<>();
        StringBuilder res = new StringBuilder();
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : s.toCharArray()) {
            // 数据进入到数字栈中
            // 99[a]
            if (Character.isDigit(c)) {
                stringBuilder.append(c);
            } else if (c != ']') {
                charStack.push(Character.toString(c));

                if (!stringBuilder.isEmpty()) {
                    countStack.push(Integer.parseInt(stringBuilder.toString()));
                    stringBuilder = new StringBuilder();
                }
            } else {
                // 此时遇到了 ]
                // 先出栈charStack,直到遇到[
                if (!charStack.isEmpty()) {
                    StringBuilder oneTempString = new StringBuilder();

                    String pop = charStack.pop();
                    while (!pop.equals("[")) {
                        oneTempString.insert(0, pop);
                        pop = charStack.pop();
                    }
                    // 此时出栈到了 [
                    // 此时获取数字栈中的第一个
                    Integer count = countStack.pop();
                    String tempRes = oneTempString.toString().repeat(Math.max(0, count));
                    charStack.push(tempRes);
                }
            }
        }

        // 处理一下字符开头的情况
        for (String s1 : charStack) {
            res.append(s1);
        }

        return res.toString();

    }

    public static void main(String[] args) {
        P394 p394 = new P394();
        String test = "3[a]10[bc]";
        System.out.println(p394.decodeString(test));
    }
}
