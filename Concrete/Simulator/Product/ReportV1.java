package Concrete.Simulator.Product;

import Abstract.Simulator.Product.Processor;
import Abstract.Simulator.Product.Report;
import Abstract.Simulator.Product.Task;

import java.util.*;

public class ReportV1 implements Report {
    @Override
    public void printReport(HashMap<ProcessorV1, Queue<Task>> reportData) {


        List<Processor> processorList = new ArrayList<>();
        for (Map.Entry<ProcessorV1, Queue<Task>> set :
                reportData.entrySet()) {
            processorList.add(set.getKey());
        }
        processorList.sort(Comparator.comparing(Processor::getId));

        String temp = "\t\tT";
        for (int x = 0; x < ClockV1.clock_instance.numberOfCycles; x++) {
            System.out.print("\t\tC" + (x + 1));
        }
        System.out.println();
        for (int x = 0; x < reportData.size(); x++) {
            Queue<Task> tasks1 = reportData.get(processorList.get(x));
            System.out.print("P" + processorList.get(x).getId());
            int z = 1;
            while (z <= ClockV1.clock_instance.numberOfCycles) {
                if (tasks1.peek() == null) {
                    z++;
                    continue;
                }
                if (z < tasks1.peek().getCreationTime()) {
                    z++;
                    System.out.print("       ");
                    continue;
                }
                int N = tasks1.peek().getBurstTime();
                for (int i = 0; i < N; i++) {
                    System.out.print(temp + tasks1.peek().getId());
                    z++;
                    if(z > ClockV1.getInstance().numberOfCycles)
                    {
                        break;
                    }
                }
                tasks1.poll();
            }
            System.out.println();
        }
    }
}
