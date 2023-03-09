package Concrete.Simulator.Product;

import Abstract.Simulator.Product.Processor;
import Abstract.Simulator.Product.Task;

public class ProcessorV1 implements Processor {
    int id;
    int runningTime;

    public ProcessorV1(int id, int runningTime) {
        this.id = id;
        this.runningTime = runningTime;
    }

    @Override
    public int getId() {
        return id;
    }
    @Override
    public int getRunningTime() {
        return runningTime;
    }
    @Override
    public void setRunningTime(int runningTime) {
        this.runningTime = runningTime;
    }
    @Override
    public void executeTask(Task task)
    {
        SchedulerV1.getInstance().reportData.get(this).offer(task);
        SchedulerV1.getInstance().getBusyProcessors().put(this,task);
        printTaskStart(task);
    }

    @Override
    public void killTask() {
        SchedulerV1.getInstance().readyProcessors.addLast(this);
        SchedulerV1.getInstance().readyProcessors.getLast().setRunningTime(0);
    }

    @Override
    public String toString() {
        return "ProcessorV1{" +
                "id=" + id +
                ", runningTime=" + runningTime +
                '}';
    }
    @Override
    public void printTaskStart(Task task)
    {
        System.out.println("\n\t\t\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("\t\t\t\t\tProcessor: ID " + this.getId() + "\t\t\t\t\t\t\t");
        System.out.println("\t\t\t\t\t   Task: ID " + task.getId() + "\t\t\t\t\t\t\t");
        System.out.println("\t\t\t\t  Started at Cycle:  " + ClockV1.clock_instance.cycles.peek().id + "\t\t\t\t\t\t");
        System.out.println("\t\t\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
        System.out.println("\t\t\t\t   ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓");
        System.out.println("\t\t\t\t   ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓");
    }

    @Override
    public int compareTo(Processor o) {
        if(this.id > o.getId())
        {
            return 1;
        }
        else
        {
            return -1;
        }
    }
}
