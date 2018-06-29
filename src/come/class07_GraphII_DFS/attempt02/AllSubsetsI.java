package come.class07_GraphII_DFS.attempt02;

import java.util.ArrayList;
import java.util.List;

public class AllSubsetsI {
    public List<String> subSets(String set) {
        List<String> res = new ArrayList<>();
        if (set == null) {
            return res;
        }

        helper(set, res, new StringBuilder(), 0);
        return res;
    }

    private void helper(String set, List<String> res, StringBuilder sb, int idx) {
        if (idx == set.length()) {
            res.add(sb.toString());
            return;
        }

        helper(set, res, sb, idx + 1);
        sb.append(set.charAt(idx));
        helper(set, res, sb, idx + 1);
        sb.deleteCharAt(sb.length() - 1);
    }
}
