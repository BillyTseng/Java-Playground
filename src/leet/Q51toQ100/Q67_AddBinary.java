package leet.Q51toQ100;

public class Q67_AddBinary {
    public String addBinary(String a, String b) {
        int i = a.length() - 1, j = b.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0) {
            int sum = carry;
            sum += (i < 0) ? 0 : (a.charAt(i) - '0');
            sum += (j < 0) ? 0 : (b.charAt(j) - '0');
            carry = sum / 2;
            sb.append(sum % 2);
            i--;
            j--;
        }

        if (carry == 1) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}
