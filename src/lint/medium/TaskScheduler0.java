package lint.medium;

import java.util.HashMap;

/* Tasks remain original order.*/
public class TaskScheduler0 {
    /**
     * @param tasks: the given char array representing tasks CPU need to do
     * @param n: the non-negative cooling interval
     * @return: the least number of intervals the CPU will take to finish all the given tasks
     */
    public int leastInterval(char[] tasks, int n) {
        // write your code here
        if (tasks == null || tasks.length == 0) {
            return 0;
        }
        if (n <= 0) {
            return tasks.length;
        }

        int time = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < tasks.length; i++) {
            char curr = tasks[i];
            time++;
            if (!map.containsKey(curr)) {
                map.put(curr, time + n + 1);
            } else {
                int execTime = map.get(curr);
                if (time < execTime) {
                    // halt the current task
                    i--;
                } else {
                    map.put(curr, time + n + 1);
                }
            }
        }
        return time;
    }

    public static void main(String[] args) {
        TaskScheduler0 sol = new TaskScheduler0();
        /* A B _ _ A B C, interval = 7*/
        System.out.println(sol.leastInterval(new char[]{'A', 'B', 'A', 'B', 'C'}, 3));
        /* A B _ _ _ B _ _ _ B C, interval = 11*/
        System.out.println(sol.leastInterval(new char[]{'A', 'B', 'B', 'B', 'C'}, 3));
    }
}
