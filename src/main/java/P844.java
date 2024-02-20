import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class P844 {
    public boolean backspaceCompare(String s, String t) {
        // 用栈实现一次
        Deque<Character> sStack = new LinkedList<>();
        Deque<Character> tStack = new LinkedList<>();
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < s.toCharArray().length; i++) {
            if(s.charAt(i) == '#'){
                // 出栈栈顶
                if(!sStack.isEmpty()) sStack.pop();
            }else{
                sStack.push(s.charAt(i));
            }
        }
        for (int i = 0; i < t.toCharArray().length; i++) {
            if(t.charAt(i) == '#'){
                // 出栈栈顶
                if(!tStack.isEmpty()) tStack.pop();
            }else{
                tStack.push(t.charAt(i));
            }
        }
        for (Character character : sStack) {
            sb1.append(character);
        }
        for (Character character : tStack) {
            sb2.append(character);
        }
        return sb1.toString().equals(sb2.toString());
    }

    public static void main(String[] args) {
        P844 p844 = new P844();
        System.out.println(p844.backspaceCompare("a#c", "b"));
    }
}
