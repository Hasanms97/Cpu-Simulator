package Abstract.Simulator.Product;

public interface Task extends Comparable<Task> {
    public int getCreationTime();
    public int getBurstTime();
    public int getPriority();
    public int getId();
}
