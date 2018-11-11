package leet.topics.dynamicProgramming;

/* 838. Push Dominoes - medium */

public class PushDominoes {
    public String pushDominoes(String dominoes) {
        char[] chars = dominoes.toCharArray();
        final int N = chars.length;
        int[] forces = new int[N];

        int force = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'R') {
                force = N;
            } else if (chars[i] == 'L') {
                force = 0;
            } else {
                force = Math.max(force - 1, 0);
            }
            forces[i] += force;
        }

        force = 0;
        for (int j = chars.length - 1; j >= 0; j--) {
            if (chars[j] == 'R') {
                force = 0;
            } else if (chars[j] == 'L') {
                force = N;
            } else {
                force = Math.max(force - 1, 0);
            }
            forces[j] -= force;
        }

        StringBuilder ans = new StringBuilder();
        for (int f : forces) {
            ans.append(f > 0 ? 'R' : f < 0 ? 'L' : '.');
        }
        return ans.toString();
    }
}
