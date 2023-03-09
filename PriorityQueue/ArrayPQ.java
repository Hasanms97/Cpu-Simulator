package PriorityQueue;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayPQ <E extends Comparable<E>> implements MaxPQ<E>{
    private E[] array; // maintain items in a heap order
    private int n;

    public ArrayPQ(){
        n = 0;
        array = (E[]) new Comparable[2];
    }

    @Override
    public void insert(E item) { // O(log N)
        if(item==null)
            throw new IllegalArgumentException();
        if (n == array.length - 1)
            resize(array.length * 2);
        n++;
        array[n] = item;
        swim(n);
    }

    private void swim(int k) {
        while (k > 1 && less(k/2, k)) {
            exch(k, k/2);
            k = k/2;
        }
    }

    @Override
    public E delMax() {
        if(n==0)
            throw new NoSuchElementException();
        E tmp = array[1];
        exch(1,n);
        array[n] = null;
        n--;
        sink(1);
        if ((n > 2) && (n == (array.length - 1) / 4))
            resize(array.length / 2);
        return tmp;
    }

    private void sink(int k){
        while(2*k <= n){
            int j = 2*k;
            if(2*k+1 <= n && less(2*k,2*k+1))
                j = 2*k+1;
            if(!less(k,j)) break;
            exch(k,j);
            k = j;
        }
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public Iterator<E> iterator() { // to be completed by the student
        return null;
    }

    private boolean less(int i, int j) {
        return array[i].compareTo(array[j]) < 0;
    }

    private void exch(int i, int j) {
        E tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    private void resize(int capacity){
        E[] temp = (E[]) new Comparable[capacity];
        for (int i = 1; i <= n; i++)
            temp[i] = array[i];
        array = temp;
    }

    public E get()
    {
        return array[1];
    }
}
