package Concrete.Simulator.Product;

import PriorityQueue.*;
import Abstract.Simulator.Product.Processor;
import Abstract.Simulator.Product.Scheduler;
import Abstract.Simulator.Product.Task;

import java.util.*;

public class SchedulerV1 implements Scheduler {
    protected ArrayPQ<Task> taskArrayPQ = new ArrayPQ<>();
    protected Deque<Processor> readyProcessors = new ArrayDeque<>();
    protected HashMap<Processor, Task> busyProcessors = new HashMap<>();
    protected HashMap<ProcessorV1, Queue<Task>> reportData = new HashMap<>();
    public static SchedulerV1 obj = null;

    private SchedulerV1() {
    }

    public static SchedulerV1 getInstance() {
        if (obj == null) {
            obj = new SchedulerV1();
        }
        return obj;
    }

    @Override
    public void resetTheInstance() {
        obj = null;
    }

    @Override
    public void checkProcessorAvailability() {
        while (areProcessorsAvailable() && isThereAnyTask()) {
            assignTask();
        }
    }

    @Override
    public void assignTask() {
        Task task = taskArrayPQ.delMax();
        Processor processor = readyProcessors.poll();
        processor.executeTask(task);
    }

    @Override
    public boolean areProcessorsAvailable() {
        return readyProcessors.size() > 0;
    }

    @Override
    public boolean isThereAnyTask() {
        return taskArrayPQ.size() > 0;
    }

    @Override
    public void update() {
        Iterator<Map.Entry<Processor, Task>> iter = busyProcessors.entrySet().iterator();

        while (iter.hasNext()) {
            Map.Entry<Processor, Task> entry = iter.next();
            entry.getKey().setRunningTime(entry.getKey().getRunningTime() + 1);

            if (entry.getKey().getRunningTime() == entry.getValue().getBurstTime()) {
                printTaskFinish(entry.getKey(), entry.getValue());
                entry.getKey().killTask();
                iter.remove();
            }
        }
    }

    @Override
    public HashMap<ProcessorV1, Queue<Task>> getReportData() {
        return reportData;
    }

    @Override
    public void addTask(Task task) {
        taskArrayPQ.insert(task);
    }

    @Override
    public Deque<Processor> getReadyProcessors() {
        return readyProcessors;
    }

    @Override
    public HashMap<Processor, Task> getBusyProcessors() {
        return busyProcessors;
    }

    public void printTaskFinish(Processor processor, Task task) {
        System.out.println("\n\t\t\t-------------------------------");
        System.out.println("\t\t\t\t\tProcessor: ID " + processor.getId() + "\t\t\t\t\t\t\t");
        System.out.println("\t\t\t\t\t   Task: ID " + task.getId() + "\t\t\t\t\t\t\t");
        System.out.println("\t\t\t\t  Finished at Cycle:  " + ClockV1.clock_instance.cycles.peek().id + "\t\t\t\t\t\t");
        System.out.println("\t\t\t-------------------------------\n");
        System.out.println("\t\t\t\t   ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓");
        System.out.println("\t\t\t\t   ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓");
    }
}
