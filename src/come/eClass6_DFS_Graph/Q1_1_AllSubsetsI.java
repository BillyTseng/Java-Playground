package come.eClass6_DFS_Graph;

import java.util.ArrayList;
import java.util.List;

public class Q1_1_AllSubsetsI {
    public List<String> subSets(String set) {
        List<String> res = new ArrayList<>();
        if (set == null) {
            return res;
        }
        subSets(set, new StringBuilder(), res, 0);
        return res;
    }

    private void subSets(String input, StringBuilder sb, List<String> res, int level) {
        if (level == input.length()) {
            res.add(sb.toString());
            return;
        }

        sb.append(input.charAt(level));
        subSets(input, sb, res, level + 1);
        sb.deleteCharAt(sb.length() - 1);

        subSets(input, sb, res, level + 1);
    }
}
