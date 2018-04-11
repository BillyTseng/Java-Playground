    /* Given an array of strings, return all groups of strings that are anagrams.
     * Example
     *   Given ["lint", "intl", "inlt", "code"], return ["lint", "inlt", "intl"].
     *   Given ["ab", "ba", "cd", "dc", "e"], return ["ab", "ba", "cd", "dc"].
     */
import java.util.*;

public class Anagrams {
    /**
     * @param strs: A list of strings
     * @return: A list of strings
     */
    public List<String> anagrams(String[] strs) {
        // write your code here
        List<String> res = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return res;
        }
        HashMap<String, String> map = new HashMap<>();
        for (String str : strs) {
            char[] c = str.toCharArray();
            Arrays.sort(c);
            String sortedStr = String.valueOf(c);
            if (map.containsKey(sortedStr)) {
                String orgStr = map.get(sortedStr);
                if (!res.contains(orgStr)) {
                    res.add(orgStr);
                }
                res.add(str);
            } else {
                map.put(sortedStr, str);
            }
        }
        return res;
    }
}
