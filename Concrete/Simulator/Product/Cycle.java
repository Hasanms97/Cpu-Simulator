package Concrete.Simulator.Product;

public class Cycle {
    int id;

    public Cycle(int id) {
        this.id = id;
    }
    public int getId()
    {
        return id;
    }
    @Override
    public String toString() {
        return "Cycle{" +
                "value=" + id +
                '}';
    }
}
