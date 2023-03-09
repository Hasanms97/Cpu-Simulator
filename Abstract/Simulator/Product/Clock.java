package Abstract.Simulator.Product;

import Concrete.Simulator.Product.Cycle;

import java.util.Queue;

public interface Clock {
    public void setClockCycles(int numberOfCycles);
    public Queue<Cycle> getCycles();
    public void tickTock();
    public void resetTheInstance();
}
