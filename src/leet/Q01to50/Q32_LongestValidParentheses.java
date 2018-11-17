package leet.Q01to50;

public class Q32_LongestValidParentheses {
    private final boolean LEFT_TO_RIGHT = true;
    private final boolean RIGHT_TO_LEFT = false;
    private int leftCnt;
    private int rightCnt;
    private int maxLength;

    public int longestValidParentheses(String s) {
        leftCnt = rightCnt = maxLength = 0;
        traversString(s, LEFT_TO_RIGHT);
        leftCnt = rightCnt = 0;
        traversString(s, RIGHT_TO_LEFT);
        return maxLength;
    }

    private void traversString(String s, boolean dir) {
        if (dir == LEFT_TO_RIGHT) {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    leftCnt++;
                } else {
                    rightCnt++;
                }
                if (leftCnt == rightCnt) {
                    maxLength = Math.max(maxLength, leftCnt + rightCnt);
                } else if (rightCnt > leftCnt) {
                    leftCnt = rightCnt = 0;
                }
            }
        } else {
            for (int i = s.length() - 1; i >= 0; i--) {
                if (s.charAt(i) == '(') {
                    leftCnt++;
                } else {
                    rightCnt++;
                }
                if (leftCnt == rightCnt) {
                    maxLength = Math.max(maxLength, leftCnt + rightCnt);
                } else if (leftCnt > rightCnt) {
                    leftCnt = rightCnt = 0;
                }
            }
        }
    }
}
