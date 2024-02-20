public class P122LCR {
    public String pathEncryption(String path) {
        StringBuilder sb = new StringBuilder();
        for (char c : path.toCharArray()) {
            if(c=='.'){
                sb.append(" ");
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        P122LCR p122LCR = new P122LCR();
        System.out.println(p122LCR.pathEncryption("fengtao.lihua.zwhng.jil.jjoidsj.ds"));
    }
}
