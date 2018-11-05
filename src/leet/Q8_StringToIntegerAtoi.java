package leet;

public class Q8_StringToIntegerAtoi {
    public int myAtoi(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int n = str.length();
        int i = 0;
        while (i < n && str.charAt(i) == ' ') {
            i++;
        }

        boolean isPositive = true;
        if (i < n && (str.charAt(i) == '+' || str.charAt(i) == '-')) {
            isPositive = (str.charAt(i) == '+');
            i++;
        }

        long sum = 0;
        while (i < n && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            sum = sum * 10 + (str.charAt(i) - '0');
            if (sum > (long)Integer.MAX_VALUE + 1) {
                break;
            }
            i++;
        }

        sum = (isPositive) ? sum : -sum;
        if (sum > (long)Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }

        if (sum < (long)Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int)sum;
    }
}
