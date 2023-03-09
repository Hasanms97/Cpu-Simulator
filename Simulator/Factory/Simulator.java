package Simulator.Factory;

import Abstract.Simulator.Product.*;
import Concrete.Simulator.Product.ClockV1;
import Concrete.Simulator.Product.ProcessorV1;
import Concrete.Simulator.Product.SchedulerV1;

import java.util.*;

public class Simulator implements ISimulator{
    private final Queue<Task> tasks;
    private final Report report;

    public Simulator(SimulatorFactory simulatorFactory, int numberOfProcessors, int numberOfCycles, String filePath)
    {
        simulatorFactory.createClock(numberOfCycles);
        simulatorFactory.createScheduler();
        ArrayList<Processor>processors = simulatorFactory.createProcessor(numberOfProcessors);
        tasks = simulatorFactory.createTask(filePath);
        report = simulatorFactory.createReport();
        SchedulerV1.getInstance().getReadyProcessors().addAll(processors);

        for (Processor processor : processors) {
            SchedulerV1.getInstance().getReportData().put((ProcessorV1) processor, new ArrayDeque<>());
        }
    }
    public void checkNewTasks(int cycle)
    {
        while (!tasks.isEmpty() && tasks.peek().getCreationTime() == cycle) {
            SchedulerV1.getInstance().addTask(tasks.poll());
        }
    }
    @Override
    public void start() throws InterruptedException {
        int N = ClockV1.clock_instance.getCycles().size();
        for (int i = 1; i <= N; i++) {
            checkNewTasks(i);
            SchedulerV1.getInstance().checkProcessorAvailability();
            SchedulerV1.getInstance().update();
            ClockV1.getInstance().tickTock();
            Thread.sleep(1000);
        }
        report.printReport(SchedulerV1.obj.getReportData());
        SchedulerV1.getInstance().resetTheInstance();
        ClockV1.getInstance().resetTheInstance();
    }
}
