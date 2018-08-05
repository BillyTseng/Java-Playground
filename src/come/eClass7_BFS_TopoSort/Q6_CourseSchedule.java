package come.eClass7_BFS_TopoSort;

import java.util.ArrayDeque;
import java.util.Queue;

/* 207. Course Schedule - medium */

public class Q6_CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        for (int[] edge : prerequisites) {
            indegrees[edge[0]]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) {
                queue.offer(i);
            }
        }
        int coursesCouldHave = queue.size();
        while (!queue.isEmpty()) {
            Integer cur = queue.poll();
            for (int[] edge : prerequisites) {
                if (cur == edge[1]) {
                    indegrees[edge[0]]--;
                    if (indegrees[edge[0]] == 0) {
                        queue.offer(edge[0]);
                        coursesCouldHave++;
                    }
                }
            }
        }
        return coursesCouldHave == numCourses;
    }
}
