package come.class07_GraphII_DFS;

import java.util.ArrayList;
import java.util.List;

public class Q1_AllSubsetsI {
    private List<String> subSets(String set) {
        List<String> res = new ArrayList<>();
        if (set == null) {
            return res;
        }
        StringBuilder sb = new StringBuilder();
        dfs(set, res, 0, sb);
        return res;
    }

    private void dfs(String set, List<String> res, int idx, StringBuilder sb) {
        if (idx == set.length()) {
            res.add(sb.toString());
            return;
        }
        dfs(set, res, idx + 1, sb);

        dfs(set, res, idx + 1, sb.append(set.charAt(idx)));
        sb.deleteCharAt(sb.length() - 1);
    }

    public static void main(String[] args) {
        Q1_AllSubsetsI solution = new Q1_AllSubsetsI();
        for (String str : solution.subSets("abc")) {
            System.out.println(str);
        }

        for (String str : solution.subSets("1234")) {
            System.out.println(str);
        }

    }
}
