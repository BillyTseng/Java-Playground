package come.practice.class25.ElevatorSimulator;

import java.util.Queue;

public class Elevator {
    private static final int DEFAULT_ELEVATOR_MAX_CAPACITY = 10;
    private static final int DEFAULT_ELEVATOR_MAX_FLOOR = 10;
    private static final int DEFAULT_INITIAL_LOCATION = 1;

    private final int maxCapacity;
    private final int maxFloor;
    private int load;
    private int location;
    private boolean isGoingUp;

    private int[] requests;

    Elevator(int maxCapacity, int maxFloor) {
        this.maxCapacity = maxCapacity;
        this.maxFloor = maxFloor;
        load = 0;
        location = DEFAULT_INITIAL_LOCATION;
        isGoingUp = true;
        requests = new int[maxFloor];
    }

    public Elevator() {
        this(DEFAULT_ELEVATOR_MAX_CAPACITY, DEFAULT_ELEVATOR_MAX_FLOOR);
    }

    public boolean isEmpty() {
        return load == 0;
    }

    boolean isFull() {
        return load >= maxCapacity;
    }

    int getLocation() {
        return location;
    }

    int move() {
        if (isGoingUp) {
            return (location + 1 <= maxFloor) ? ++location : location;
        } else {
            return (location - 1 >= 0) ? --location : location;
        }
    }

    boolean changeMovingDirection() {
        isGoingUp = !isGoingUp;
        return isGoingUp;
    }

    int load(Queue<Integer> currQueue) {
        int numNewLoad = currQueue.size();
        if (load + numNewLoad > maxCapacity) {
            return 0;
        }
        for (int requestedFloor : currQueue) {
            requests[requestedFloor - 1] += 1;
        }
        load += numNewLoad;
        currQueue.clear();
        return numNewLoad;
    }

    int unload() {
        int numRequests = requests[location - 1];
        if (numRequests > 0) {
            load -= numRequests;
            requests[location - 1] = 0;
            return numRequests;
        }
        return 0;
    }
}
