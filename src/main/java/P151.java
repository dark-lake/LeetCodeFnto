import java.util.Arrays;
import java.util.LinkedList;

public class P151 {
    public String reverseWords(String s) {
        // 使用栈方便倒叙
        LinkedList<String> stack = new LinkedList<>();
        // sb用来记录每个单词
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.toCharArray().length; i++) {
            char c = s.charAt(i);
            // 如果c不是" "那就加入到sb中, 如果是" "那就判断sb是不是不为空,如果是那就加入到栈中,sb清空
            if (c != ' ') {
                sb.append(c);
            } else {
                // 判断此时的sb是否为空?
                if (!sb.isEmpty()) {
                    stack.push(sb.toString());
                    stack.push(" ");
                    sb = new StringBuilder();
                }
            }
        }
        // 如果最后一位不是" "那么sb就是最后一个单词,加入到栈中
        if (!sb.isEmpty()) stack.push(sb.toString());
        // sb 清空来做最后的结果
        sb = new StringBuilder();
        // 将栈中拼接起来, 其中第一个也就是最后一个入栈的有可能是" ",所以要跳过
        for (int i = 0; i < stack.size(); i++) {
            if (i == 0 && stack.get(i).equals(" ")) continue;
            sb.append(stack.get(i));
        }
        return sb.toString();
    }

    public String reverseWords1(String s) {
        char[] chars = s.toCharArray();
        char[] res = new char[s.length() + 1];
        int count = 0;
        int i = s.length() - 1;
        while(i>=0) {
            // 从后往前走,如果是空格就跳过找到第一个不是空格的
            while (i >= 0 && chars[i] == ' ') {
                i--;
            }
            // 记录单词的末尾索引
            int r = i;
            // 找到这个单词的开头
            while (i >= 0 && chars[i] != ' ') {
                i--;
            }
            // 此时的i是 ' ';
            for (int j = i + 1; j <= r; j++) {
                res[count++] = chars[j];
                if (j==r) res[count++] = ' ';
            }
        }
        System.out.println(Arrays.toString(res));

        return new String(res, 0, count - 1);
    }

    public static void main(String[] args) {
        P151 p151 = new P151();
        System.out.println("|" + p151.reverseWords1("the sky is blue") + "|");
    }
}
