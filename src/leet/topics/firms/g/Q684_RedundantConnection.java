package leet.topics.firms.g;

public class Q684_RedundantConnection {
    public int[] findRedundantConnection(int[][] edges) {
        final int MAX_EDGE = 1000;
        DSU dsu = new DSU(MAX_EDGE + 1);
        for (int[] edge : edges) {
            if (!dsu.union(edge[0], edge[1])) {
                return edge;
            }
        }
        throw new AssertionError();
    }

    private class DSU {
        int[] id;
        DSU(int size) {
            id = new int[size];
            for (int i = 0; i < size; i++) {
                id[i] = i;
            }
        }

        public int find(int x) {
            while (x != id[x]) {
                x = id[x];
            }
            return x;
        }

        boolean union(int x, int y) {
            int xId = find(x);
            int yId = find(y);
            if (xId == yId) {
                return false;
            }
            id[xId] = yId;
            return true;
        }
    }
}
