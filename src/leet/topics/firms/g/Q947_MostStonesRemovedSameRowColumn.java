package leet.topics.firms.g;

import java.util.HashSet;
import java.util.Set;

public class Q947_MostStonesRemovedSameRowColumn {
    public int removeStones(int[][] stones) {
        int N = stones.length;
        DSU dsu = new DSU(20000);

        for (int[] stone : stones) {
            dsu.union(stone[0], stone[1] + 10000);
        }

        Set<Integer> seen = new HashSet<>();
        for (int[] stone : stones) {
            seen.add(dsu.find(stone[0]));
        }
        return N - seen.size();
    }

    private class DSU {
        int[] id;
        DSU(int N) {
            id = new int[N];
            for (int i = 0; i < N; i++) {
                id[i] = i;
            }
        }

        public int find(int x) {
            while (x != id[x]) {
                x = id[x];
            }
            return x;
        }

        void union(int x, int y) {
            id[find(x)] = find(y);
        }
    }
}
