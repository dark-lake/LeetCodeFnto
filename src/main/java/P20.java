import java.util.Stack;

public class P20 {
    public boolean isValid(String s) {
        if(s.isEmpty()){
            return false;
        }
        Stack<Character> characterStack = new Stack<>();
        for (char c : s.toCharArray()) {
            if(c == '(' || c== '{' || c=='['){
                characterStack.push(c);
            }else{
                if(characterStack.isEmpty()){
                    return false;
                }
                Character pop = characterStack.pop();
                if(c==')' && pop != '('){
                    return false;
                }
                if(c=='}' && pop != '{'){
                    return false;
                }
                if(c==']' && pop != '['){
                    return false;
                }
            }
        }
        return characterStack.isEmpty();
    }

    public static void main(String[] args) {
        P20 p20 = new P20();
        String test = "(){}}{";
        System.out.println(p20.isValid(test));
    }
}
