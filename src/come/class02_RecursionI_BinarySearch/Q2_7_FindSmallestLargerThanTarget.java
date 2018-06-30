package come.class02_RecursionI_BinarySearch;
/* https://leetcode.com/problems/find-smallest-letter-greater-than-target/description/ */
// Variant 1.6 how to find the smallest element that is larger than a target number.
public class Q2_7_FindSmallestLargerThanTarget {
    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0;
        int right = letters.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (letters[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return letters[left % letters.length];
    }
    public static void main(String[] args) {
        Q2_7_FindSmallestLargerThanTarget solution = new Q2_7_FindSmallestLargerThanTarget();
        char[] array = new char[]{'c','f','j'};
        System.out.println(solution.nextGreatestLetter(array, 'j'));
    }
}
