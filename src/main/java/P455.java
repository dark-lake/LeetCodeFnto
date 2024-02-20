import java.util.Arrays;

public class P455 {
    public int findContentChildren(int[] g, int[] s) {
        if (s.length == 0) return 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int res = 0;
        boolean over = false;
        for (int i = 0; i < g.length; i++) {
            for (int j = 0; j < s.length; j++) {
                if (s[s.length - 1] < g[i]) over = true;
                if (s[j] >= g[i] && s[j] != 0) {
                    res++;
                    s[j] = 0;
                    break;
                }
            }
            if (over) break;
        }
        return res;
    }

    public int findContentChildren1(int[] g, int[] s) {
        if (s.length == 0) return 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int res = 0, i = 0, j = 0;
        while ((i < g.length) && (j < s.length)){
            if(s[j] >= g[i]){
                res++;
                i++;
            }
            j++;
        }
        return res;
    }


    public static void main(String[] args) {
        P455 p455 = new P455();
        int[] g = {1, 2};
        int[] s = {1, 2, 3};
        System.out.println(p455.findContentChildren(g, s));
    }
}
