package Concrete.Simulator.Product;

import Abstract.Simulator.Product.Clock;

import java.util.*;

public class ClockV1 implements Clock {
    Queue<Cycle> cycles = new LinkedList<>();
    public static ClockV1 clock_instance = null;
    public int numberOfCycles = 0;

    private ClockV1() {
    }

    public static ClockV1 getInstance() {
        if (clock_instance == null) {
            clock_instance = new ClockV1();
        }
        return clock_instance;
    }

    @Override
    public void resetTheInstance() {
        clock_instance = null;
    }

    @Override
    public void setClockCycles(int numberOfCycles) {
        for (int i = 0; i < numberOfCycles; i++) {
            cycles.add(new Cycle(i + 1));
        }
        this.numberOfCycles = numberOfCycles;
    }

    @Override
    public Queue<Cycle> getCycles() {
        return cycles;
    }

    @Override
    public void tickTock() {
        cycles.poll();
    }

    @Override
    public String toString() {
        return "ClockV1{" +
                "cycles=" + cycles +
                '}';
    }
}
