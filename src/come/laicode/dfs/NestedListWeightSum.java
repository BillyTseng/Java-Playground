package come.laicode.dfs;

public class NestedListWeightSum {
    public int depthSum(String nestlists) {
        if (nestlists == null || nestlists.length() == 0) {
            return 0;
        }
        int[] sum = new int[] {0};
        depthSum(nestlists, 0, 0, sum);
        return sum[0];
    }

    private void depthSum(String input, int depth, int idx, int[] sum) {
        if (idx == input.length()) {
            return;
        }

        if (input.charAt(idx) == '[') {
            depth++;
            idx++;
        } else if (input.charAt(idx) == ']') {
            depth--;
            idx++;
        } else if (input.charAt(idx) == ',') {
            idx++;
        } else if (Character.isDigit(input.charAt(idx)) || input.charAt(idx) == '-') {
            boolean isNegative = false;
            int currentSum = 0;
            if (input.charAt(idx) == '-') {
                isNegative = true;
                idx++;
            }
            while (Character.isDigit(input.charAt(idx))) {
                currentSum = currentSum * 10 + (input.charAt(idx) - '0');
                idx++;
            }
            if (isNegative) {
                currentSum = -currentSum;
            }
            sum[0] += currentSum * depth;
        } else {
            idx++;
        }
        depthSum(input, depth, idx, sum);
    }
}
