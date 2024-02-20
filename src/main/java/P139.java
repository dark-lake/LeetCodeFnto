import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        // 这里相当于每次往回退,一直找到前一个dp为ture的子串,真牛
        for (int i = 1; i <= s.toCharArray().length; i++) {
            for(int j=i-1; j>=0;j--){
                String str = s.substring(j, i);
                if(dp[j] && wordDict.contains(str)){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        P139 p139 = new P139();
        boolean b = p139.wordBreak("aaaaaaa", new ArrayList<>() {{
            add("aaaa");
            add("aaa");
        }});
        System.out.println(b);
    }
}
