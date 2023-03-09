package Concrete.Simulator.Product;

import Abstract.Simulator.Product.Task;

public class TaskV1 implements Task, Comparable<Task>{
    int id;
    int creationTime;
    int burstTime;
    int priority;

    public TaskV1(int id, int creationTime, int burstTime, int priority) {
        this.id = id;
        this.creationTime = creationTime;
        this.burstTime = burstTime;
        this.priority = priority;
    }

    @Override
    public int getId() {
        return id;
    }
    @Override
    public int getCreationTime() {
        return creationTime;
    }
    @Override
    public int getBurstTime() {
        return burstTime;
    }
    @Override
    public int getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return "TaskV1{" +
                "id=" + id +
                ", creationTime=" + creationTime +
                ", burstTime=" + burstTime +
                ", priority=" + priority +
                '}';
    }
    @Override
    public int compareTo(Task o) {
        if(this.priority == o.getPriority())
        {
            if(this.burstTime > o.getBurstTime())
            {
                return 1;
            }
        }
        else if(this.priority > o.getPriority())
        {
            return 1;
        }
        return -1;
    }
}
