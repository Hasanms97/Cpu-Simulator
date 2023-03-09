package Simulator.Factory;

import Abstract.Simulator.Product.*;

import java.util.ArrayList;
import java.util.Queue;

 public interface SimulatorFactory {
    public Clock createClock(int numberOfCycles);
    public ArrayList<Processor> createProcessor(int numberOfProcessors);
    public Queue<Task> createTask(String filePath);
    public Scheduler createScheduler();
    public Report createReport();
}