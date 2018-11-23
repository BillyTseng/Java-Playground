package leet.Q51toQ100;

public class Q66_PlusOne {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int digit = carry + digits[i];
            carry = digit / 10;
            digits[i] = digit % 10;
        }

        if (carry == 0) {
            return digits;
        } else {
            int[] output = new int[digits.length + 1];
            for (int i = 0; i < output.length; i++) {
                if (i == 0) {
                    output[i] = carry;
                } else {
                    output[i] = digits[i - 1];
                }
            }
            return output;
        }
    }
}
