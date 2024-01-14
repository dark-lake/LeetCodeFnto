import java.util.*;

/**
 * 字母异位词分组
 */
public class P49 {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> value = new HashMap();
        for(int i=0;i<strs.length;i++){
            char[] array = strs[i].toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            List<String> temp_data = value.getOrDefault(key, new ArrayList<String>());
            temp_data.add(strs[i]);
            value.put(key, temp_data);
        }
        return new ArrayList<List<String>>(value.values());
    }

    public static void main(String[] args) {
        String[] data = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(data));
    }
}
