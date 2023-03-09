package Abstract.Simulator.Product;

import Concrete.Simulator.Product.ProcessorV1;

import java.util.HashMap;
import java.util.Queue;

public interface Report {
    public void printReport(HashMap<ProcessorV1, Queue<Task>> reportData);
}
