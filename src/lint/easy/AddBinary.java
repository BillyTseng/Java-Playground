/*Given two binary strings, return their sum (also a binary string).*/
package lint.easy;

public class AddBinary {
    /**
     * @param a: a number
     * @param b: a number
     * @return: the result
     */
    public String addBinary(String a, String b) {
        // write your code here
        String ans = "";

        int i = a.length() - 1;
        int j = b.length() - 1;
        int sum = 0, carry = 0;
        while (i >= 0 || j >=0) {
            sum = carry;
            sum += (i >= 0) ? a.charAt(i) - '0' : 0;
            sum += (j >= 0) ? b.charAt(j) - '0' : 0;
            carry = sum / 2;
            ans = (sum % 2) + ans;
            i--;
            j--;
        }
        if (carry != 0) {
            ans = carry + ans;
        }
        return ans;
    }
}
