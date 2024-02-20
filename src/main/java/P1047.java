import java.util.LinkedList;

public class P1047 {
    public String removeDuplicates(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        // 每次新的元素都先和栈顶比较一下,如果相同就出栈,如果不同就入栈,最后返回栈中字符拼接
        for (int i = 0; i < s.toCharArray().length; i++) {
            if (stack.isEmpty() || s.charAt(i) != stack.peek()) {
                stack.push(s.charAt(i));
            } else {
                stack.pop();
            }
        }
        // 这里要将剩下的字符倒序拼接
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        sb.reverse();
        return sb.toString();
    }

    public String removeDuplicates1(String s) {
        char[] str = s.toCharArray();
        int slow = 0;
        int fast = 0;
        while(fast<s.length()){
            str[slow] = str[fast];
            if(slow > 0 && str[slow] == str[slow-1]){
                slow--;
            }else{
                slow++;
            }
            fast++;
        }
        return new String(str, 0, slow);
    }

    public static void main(String[] args) {
        P1047 p1047 = new P1047();
        System.out.println(p1047.removeDuplicates1("abbaca"));
    }
}
