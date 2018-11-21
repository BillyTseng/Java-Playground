package leet.Q51toQ100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q60_PermutationSequence {
    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        int[] factorial = new int[n];
        List<Character> num = new ArrayList<>();

        Arrays.fill(factorial, 1);
        for(int i = 1; i < n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }

        for(int i = 0; i < n; i++) {
            num.add((char)('0' + (i + 1)));
        }

        k--;
        for(int i = n; i >= 1; i--) {
            int j = k / factorial[i - 1];
            k %= factorial[i - 1];
            sb.append(num.get(j));
            num.remove(j);
        }

        return sb.toString();
    }
}
