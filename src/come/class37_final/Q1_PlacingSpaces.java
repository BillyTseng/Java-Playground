package come.class37_final;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a string, we can insert at most one empty space between each pair of adjacent letters.
 * Print all permutations of strings after insertions of empty spaces.
 * https://www.geeksforgeeks.org/print-possible-strings-can-made-placing-spaces/
 */

public class Q1_PlacingSpaces {
    private List<String> permutations(String input) {
        List<String> res = new ArrayList<>();
        if (input == null || input.length() == 0) {
            return res;
        }
        permutations(input, res, 0, new StringBuilder());
        return res;
    }

    private void permutations(String input, List<String> res, int level, StringBuilder sb) {
        if (level == input.length() - 1) {
            sb.append(input.charAt(level));
            res.add(sb.toString());
            sb.deleteCharAt(sb.length() - 1);
            return;
        }

        sb.append(input.charAt(level));
        sb.append(" ");
        permutations(input, res, level + 1, sb);
        sb.deleteCharAt(sb.length() - 1);

        permutations(input, res, level + 1, sb);
        sb.deleteCharAt(sb.length() - 1);
    }

    public static void main(String[] args) {
        Q1_PlacingSpaces solution = new Q1_PlacingSpaces();
        System.out.println(Arrays.toString(solution.permutations(null).toArray()));
        System.out.println(Arrays.toString(solution.permutations("").toArray()));
        System.out.println(Arrays.toString(solution.permutations("ABC").toArray()));
        System.out.println(Arrays.toString(solution.permutations("wxyz").toArray()));
    }
}
