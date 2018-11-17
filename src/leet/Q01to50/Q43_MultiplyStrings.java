package leet.Q01to50;

public class Q43_MultiplyStrings {
    public String multiply(String str1, String str2) {
        String num1 = new StringBuilder(str1).reverse().toString();
        String num2 = new StringBuilder(str2).reverse().toString();
        int[] digits = new int[num1.length() + num2.length()];

        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                digits[i + j] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < digits.length; i++) {
            int mod = digits[i] % 10;
            int carry = digits[i] / 10;
            if (i + 1 < digits.length) {
                digits[i + 1] += carry;
            }
            sb.insert(0, mod);
        }

        while (sb.charAt(0) == '0' && sb.length() > 1) {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }
}
