package come.class28_DFS_2Sum;

import java.util.ArrayList;
import java.util.List;

public class Q2_4b_printAllIfBlocks {
    public void printAllIfBlocks(int n) {
        List<String> res = new ArrayList<>();
        listPossibleStr(n, 0, 0, new StringBuilder(), res);
        printBlocks(res);
    }

    private void listPossibleStr(int n, int l, int r, StringBuilder sb, List<String> res) {
        if (l == n && r == n) {
            res.add(sb.toString());
            return;
        }

        if (l < n) {
            listPossibleStr(n, l + 1, r, sb.append('{'), res);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (r < l) {
            listPossibleStr(n, l, r + 1, sb.append('}'), res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    private void printBlocks(List<String> res) {
        int indent = 0;
        for (String str : res) {
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '{') {
                    printSpace(indent++);
                    System.out.println("if {");
                } else {
                    printSpace(--indent);
                    System.out.println("}");
                }
            }
            System.out.println();
        }
    }

    private void printSpace(int indent) {
        for (int i = 0; i < indent; i++) {
            System.out.print("  ");
        }
    }
}
