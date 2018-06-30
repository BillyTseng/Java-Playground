package come.practice.class25.ElevatorSimulator;

import java.util.*;

public class Simulator {
    private final int floors;
    private List<Queue<Integer>> requests;
    private List<Elevator> elevators;
    private Scheduler scheduler;

    private Simulator(int floors,
                      int numElevators,
                      Scheduler scheduler,
                      List<Queue<Integer>> initialRequests,
                      int elevatorCapacity) {
        this.floors = floors;
        this.scheduler = scheduler;
        requests = initialRequests;
        elevators = new ArrayList<>();
        for (int i =0; i < numElevators; i++) {
            Elevator ele = new Elevator(elevatorCapacity, floors);
            elevators.add(ele);
        }
    }

    private void generateRequest() {
    }

    private void schedule() {
        scheduler.schedule(requests, elevators, floors);
    }

    private void elevatorOp() {
        for (Elevator e : elevators) {
            if (!e.isEmpty()) {
                e.unload();
            }
            if (!e.isFull()) {
                int location = e.getLocation();
                e.load(requests.get(location - 1));
            }
            e.move();
        }
    }

    private void simulate(int steps) throws InterruptedException {
        for (int i = 0; i < steps; i++) {
            generateRequest();
            schedule();
            elevatorOp();
            Thread.sleep(10);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SimpleScheduler scheduler = new SimpleScheduler();
        int floors = 10;
        int numElevators = 1;
        List<Queue<Integer>> initialRequests = new ArrayList<>();
        for (int i = 0; i < floors; i++) {
            Queue<Integer> currQueue = new LinkedList<>();
            Random rand = new Random();
            int req = rand.nextInt(floors);
            currQueue.offer(req);
            initialRequests.add(currQueue);
        }
        Simulator mySimulator = new Simulator(floors, numElevators, scheduler, initialRequests, 14);
        mySimulator.simulate(10);
    }
}
