package come.class28_DFS_2Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q2_1d_AllSubsetsII {
    public List<String> subSets(String set) {
        List<String> res = new ArrayList<>();
        if (set == null) {
            return res;
        }
        char[] cArray = set.toCharArray();
        Arrays.sort(cArray);
        subSets(cArray, new StringBuilder(), 0, set.length(), res);
        return res;
    }

    private void subSets(char[] cArray, StringBuilder sb, int idx, int size, List<String> res) {
        if (idx == size) {
            res.add(sb.toString());
            return;
        }
        sb.append(cArray[idx]);
        subSets(cArray, sb, idx + 1, size, res);
        sb.deleteCharAt(sb.length() - 1);

        while (idx + 1 < cArray.length && cArray[idx] == cArray[idx + 1]) {
            idx++;
        }
        subSets(cArray, sb, idx + 1, size, res);
    }
}
