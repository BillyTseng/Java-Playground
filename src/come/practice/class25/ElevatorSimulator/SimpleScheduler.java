package come.practice.class25.ElevatorSimulator;

import java.util.List;
import java.util.Queue;

public class SimpleScheduler implements Scheduler {
    @Override
    public void schedule(List<Queue<Integer>> requests, List<Elevator> elevators, int floors) {
        for (Elevator e : elevators) {
            if (e.getLocation() == 0 || e.getLocation() == floors) {
                e.changeMovingDirection();
            }
        }
    }
}
