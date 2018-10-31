package come.planMV;

import java.util.*;

/**
 * Process local name of emails and put the same name in the same group.
 * Examples:
 * 'a.b@example.com' -> 'ab@example.com',
 * 'dupli......cate@example.com' -> 'duplicate@example.com',
 * 'd.u.p.l.i.c.a.t.e@example.com' -> 'duplicate@example.com',
 * 'ab+work@example.com' -> 'ab@example.com'
 */

public class ProcessEmailString {
    private Map<String, Integer> countMap = new HashMap<>();

    public List<List<String>> processEmailString(List<String> input) {
        List<List<String>> res = new ArrayList<>();

        for (String str : input) {
            String newString = emailStringProcessor(str);
            countMap.put(newString, countMap.getOrDefault(newString, 0) + 1);
        }

        // Group duplicated email in the same group.
        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            List<String> currLevel = new ArrayList<>();
            Integer count = entry.getValue();
            while (count-- > 0) {
                currLevel.add(entry.getKey());
            }
            res.add(currLevel);
        }

        return res;
    }

    private String emailStringProcessor(String str) {
        // assume that str only got one '@' and domain name is valid.
        StringBuilder sb = new StringBuilder();
        String[] strs = str.split("@");

        for (int i = 0; i < strs[0].length(); i++) {
            if (str.charAt(i) == '+') {
                break;
            }

            while (i < strs[0].length() && str.charAt(i) == '.') {
                i++;
            }

            if (i < strs[0].length()) {
                sb.append(strs[0].charAt(i));
            }
        }

        return sb.append('@').append(strs[1]).toString();
    }

    public static void main(String[] args) {
        List<String> input = Arrays.asList("a.b@example.com",
                                            "dupli......cate@example.com",
                                            "d.u.p.l.i.c.a.t.e@example.com",
                                            "ab+work@example1.com");

        ProcessEmailString solution = new ProcessEmailString();
        List<List<String>> res = solution.processEmailString(input);

        for (List<String> list : res) {
            for (String str : list) {
                System.out.print(str + " ");
            }
            System.out.println();
        }
    }
}
