package org.main;


import Simulator.Factory.CpuSimulator;
import Simulator.Factory.Simulator;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        /*Simulator obj2=new Simulator(new CpuSimulator(), 2, 10, "/Users/hasanal-shannag/Desktop/simulator test/src/main/java/Text files/file1.txt");
        obj2.start();
        Simulator obj1=new Simulator(new CpuSimulator(), 4, 12, "/Users/hasanal-shannag/Desktop/simulator test/src/main/java/Text files/file2.txt");
        obj1.start();*/

        Simulator obj3=new Simulator(new CpuSimulator(), 4, 7, "/Users/hasanal-shannag/Desktop/simulator test/src/main/java/Text files/file3.txt");
        obj3.start();
        }
    }