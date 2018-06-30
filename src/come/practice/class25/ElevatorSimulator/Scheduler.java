package come.practice.class25.ElevatorSimulator;

import java.util.List;
import java.util.Queue;

public interface Scheduler {
    void schedule(List<Queue<Integer>> requests, List<Elevator> elevators, int floors);
}
