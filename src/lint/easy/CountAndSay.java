package lint.easy;

public class CountAndSay {
    /**
     * @param n: the nth
     * @return: the nth sequence
     */
    public String countAndSay(int n) {
        // write your code here
        String ans = "1";
        while (--n > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < ans.length(); i++) {
                int cnt = 1;
                char item = ans.charAt(i);
                while (i + 1 < ans.length() &&
                        ans.charAt(i) == ans.charAt(i + 1)) {
                    cnt++;
                    i++;
                }
                sb.append(String.valueOf(cnt)).append(String.valueOf(item));
            }
            ans = sb.toString();
        }
        return ans;
    }
}
