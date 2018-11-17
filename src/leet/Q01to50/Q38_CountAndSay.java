package leet.Q01to50;

public class Q38_CountAndSay {
    public String countAndSay(int n) {
        String oldStr = "1";
        while (--n > 0) {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < oldStr.length(); i++) {
                int cnt = 1;
                while (i + 1 < oldStr.length() && oldStr.charAt(i) == oldStr.charAt(i + 1)) {
                    cnt++;
                    i++;
                }
                sb.append(String.valueOf(cnt)).append(String.valueOf(oldStr.charAt(i)));
            }
            oldStr = sb.toString();
        }
        return oldStr;
    }
}
