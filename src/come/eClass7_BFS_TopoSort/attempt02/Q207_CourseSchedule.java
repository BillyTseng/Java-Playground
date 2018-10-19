package come.eClass7_BFS_TopoSort.attempt02;

import java.util.ArrayDeque;
import java.util.Queue;

public class Q207_CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegrees = new int[numCourses];
        for (int[] edge : prerequisites) {
            inDegrees[edge[0]]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < inDegrees.length; i++) {
            if (inDegrees[i] == 0) {
                queue.offer(i);
            }
        }

        int couldHaveCourse = queue.size();

        while (!queue.isEmpty()) {
            Integer curr = queue.poll();
            for (int[] edge : prerequisites) {
                if (edge[1] == curr) {
                    inDegrees[edge[0]]--;
                    if (inDegrees[edge[0]] == 0) {
                        queue.offer(edge[0]);
                        couldHaveCourse++;
                    }
                }
            }
        }
        return couldHaveCourse == numCourses;
    }
}
