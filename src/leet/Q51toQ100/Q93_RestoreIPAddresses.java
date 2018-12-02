package leet.Q51toQ100;

import java.util.ArrayList;
import java.util.List;

public class Q93_RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() < 4 || s.length() > 12) {
            return res;
        }
        List<String> listOfValidDigits = new ArrayList<>();
        helper(s, 0, listOfValidDigits, res);
        return res;
    }

    private void helper(String s, int idx, List<String> list, List<String> res) {
        if (list.size() == 4) {
            if (idx != s.length()) {
                // input s is not consumed yet.
                return;
            }
            StringBuilder sb = new StringBuilder();
            for (String tmp : list) {
                sb.append(tmp).append('.');
            }
            sb.deleteCharAt(sb.length() - 1);
            res.add(sb.toString());
            return;
        }

        for (int i = idx; i < s.length() && i < idx + 3; i++) {
            String tmp = s.substring(idx, i + 1);
            if (isValid(tmp)) {
                list.add(tmp);
                helper(s, i + 1, list, res);
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean isValid(String input) {
        if (input.charAt(0) == '0') {
            return input.equals("0");
        }
        int value = Integer.valueOf(input);
        return 0 <= value && value <= 255;
    }
}
