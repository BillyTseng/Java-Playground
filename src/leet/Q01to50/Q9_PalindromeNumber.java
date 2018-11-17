package leet.Q01to50;

public class Q9_PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int reverse = 0;
        int originalX = x;

        while (x != 0) {
            reverse = reverse * 10 + x % 10;
            x /= 10;
        }

        return reverse == originalX;
    }
}
