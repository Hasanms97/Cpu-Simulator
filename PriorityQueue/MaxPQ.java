package PriorityQueue;


public interface MaxPQ<E extends Comparable<E>> extends Iterable<E> {
    public void insert(E item);
    public E delMax();
    public int size();
}
