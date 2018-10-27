package come.planMV.arrays;

public class PlusOne {
    public int[] plus(int[] digits) {
        if (digits == null || digits.length == 0) {
            return digits;
        }
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = digits[i] + carry;
            carry = sum / 10;
            digits[i] = sum % 10;
        }

        if (carry >= 1) {
            int[] res = new int[digits.length + 1];
            for (int i = 0; i < digits.length; i++) {
                res[i + 1] = digits[i];
            }
            res[0] = carry;
            return res;
        }
        return digits;
    }
}
