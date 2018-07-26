package come.laicode.dp;

import org.junit.Test;

import static org.junit.Assert.*;

public class LongestPalindromicSubstringTest {

    @Test
    public void test1() {
        LongestPalindromicSubstring solution = new LongestPalindromicSubstring();
        String testStr = "";
        String res = solution.longestPalindrome(testStr);
        assertEquals("", res);
        String res1 = solution.longestPalindromeI(testStr);
        assertEquals("", res1);
        String res2 = solution.longestPalindromeII(testStr);
        assertEquals("", res2);
    }

    @Test
    public void test2() {
        LongestPalindromicSubstring solution = new LongestPalindromicSubstring();
        String testStr = "abcdefedcba";
        String res = solution.longestPalindrome(testStr);
        assertEquals("abcdefedcba", res);
        String res1 = solution.longestPalindromeI(testStr);
        assertEquals("abcdefedcba", res1);
        String res2 = solution.longestPalindromeII(testStr);
        assertEquals("abcdefedcba", res2);
    }

    @Test
    public void test3() {
        LongestPalindromicSubstring solution = new LongestPalindromicSubstring();
        String testStr = "abcbcbd";
        String res = solution.longestPalindrome(testStr);
        assertEquals("bcbcb", res);
        String res1 = solution.longestPalindromeI(testStr);
        assertEquals("bcbcb", res1);
        String res2 = solution.longestPalindromeII(testStr);
        assertEquals("bcbcb", res2);
    }

    @Test
    public void test4() {
        LongestPalindromicSubstring solution = new LongestPalindromicSubstring();
        String testStr = "abbc";
        String res = solution.longestPalindrome(testStr);
        assertEquals("bb", res);
        String res1 = solution.longestPalindromeI(testStr);
        assertEquals("bb", res1);
        String res2 = solution.longestPalindromeII(testStr);
        assertEquals("bb", res2);
    }
}