package come.eClass6_DFS_Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q1_2_AllSubsetsII {
    public List<String> subSets(String set) {
        List<String> res = new ArrayList<>();
        if (set == null) {
            return res;
        }
        char[] cArray = set.toCharArray();
        Arrays.sort(cArray);
        subSets(cArray, new StringBuilder(), res, 0);
        return res;
    }

    private void subSets(char[] input, StringBuilder sb, List<String> res, int level) {
        if (level == input.length) {
            res.add(sb.toString());
            return;
        }
        sb.append(input[level]);
        subSets(input, sb, res, level + 1);
        sb.deleteCharAt(sb.length() - 1);
        while (level + 1 < input.length && input[level] == input[level + 1]) {
            level++;
        }

        subSets(input, sb, res, level + 1);
    }
}
