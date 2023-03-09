package Abstract.Simulator.Product;

import Concrete.Simulator.Product.ProcessorV1;

import java.util.Deque;
import java.util.HashMap;
import java.util.Queue;

public interface Scheduler {
    public Deque<Processor> getReadyProcessors();
    public HashMap<Processor, Task> getBusyProcessors();
    public void checkProcessorAvailability();
    public void update();
    public HashMap<ProcessorV1, Queue<Task>> getReportData();
    public void addTask(Task task);
    public void assignTask();
    public boolean areProcessorsAvailable();
    public boolean isThereAnyTask();
    public void resetTheInstance();
}
