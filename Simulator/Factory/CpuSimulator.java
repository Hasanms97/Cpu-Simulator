package Simulator.Factory;

import Abstract.Simulator.Product.*;
import Concrete.Simulator.Product.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CpuSimulator implements SimulatorFactory{
    @Override
    public Clock createClock(int numberOfCycles) {
        ClockV1 obj = ClockV1.getInstance();
        obj.setClockCycles(numberOfCycles);

        return obj;
    }

    @Override
    public ArrayList<Processor> createProcessor(int numberOfProcessors) {
        ArrayList<Processor>processors = new ArrayList<>();
        for(int i = 0; i < numberOfProcessors ;i++)
        {
            processors.add(new ProcessorV1((i+1),0));
        }
        return processors;
    }

    @Override
    public Queue<Task> createTask(String filePath) {
        Queue<Task>tasks = new LinkedList<>();

        try {
            File myObj = new File(filePath);
            Scanner myReader = new Scanner(myObj);
            String data;
            int counter = 1;
            while (myReader.hasNextLine()) {
                data = myReader.nextLine();
                String[] splited = data.split("\\s+");
                tasks.add(new TaskV1(counter,Integer.parseInt(splited[0]),Integer.parseInt(splited[1]),
                        Integer.parseInt(splited[2])));
                counter++;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return tasks;
    }

    @Override
    public Scheduler createScheduler() {
        return SchedulerV1.getInstance();
    }

    @Override
    public Report createReport() {
        return new ReportV1();
    }
}