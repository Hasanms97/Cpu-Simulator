package Abstract.Simulator.Product;

public interface Processor extends Comparable<Processor> {
    public int getId();
    public int getRunningTime();
    public void setRunningTime(int runningTime);
    public void executeTask(Task task);
    public void killTask();

    void printTaskStart(Task task);
}
