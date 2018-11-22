package leet.Q51toQ100;

public class Q65_ValidNumber {
    public boolean isNumber(String str) {
        boolean num = false, numAfterE = true, dot = false, exp = false, sign = false;
        int n = str.length();
        char[] s = str.toCharArray();

        for (int i = 0; i < n; ++i) {
            if (s[i] == ' ') {
                if (i < n - 1 && s[i + 1] != ' ' && (num || dot || exp || sign))
                    return false;
            } else if (s[i] == '+' || s[i] == '-') {
                if (i > 0 && s[i - 1] != 'e' && s[i - 1] != ' ')
                    return false;
                sign = true;
            } else if (s[i] >= '0' && s[i] <= '9') {
                num = true;
                numAfterE = true;
            } else if (s[i] == '.') {
                if (dot || exp)
                    return false;
                dot = true;
            } else if (s[i] == 'e') {
                if (exp || !num)
                    return false;
                exp = true;
                numAfterE = false;
            } else
                return false;
        }
        return num && numAfterE;
    }
}
