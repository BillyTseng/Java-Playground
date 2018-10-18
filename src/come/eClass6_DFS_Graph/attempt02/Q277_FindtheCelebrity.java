package come.eClass6_DFS_Graph.attempt02;

public class Q277_FindtheCelebrity {
    public int findCelebrity(int n) {
        int res = 0;
        for (int a = 0; a < n; a++) {
            if (knows(res, a)) {
                res = a;
            }
        }

        for (int b = 0; b < n; b++) {
            if (res != b && (knows(res, b) || !knows(b, res))) {
                return -1;
            }
        }
        return res;
    }

    // pseudo code
    boolean knows(int a, int b){
        return true;
    }
}
