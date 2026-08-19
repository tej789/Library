package com.tej.librarymanagement.model;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Counter1 {

    int count = 0;

    public synchronized void increment() {
        count++;
    }

    public synchronized int getCount() {
        return count;
    }
}

public class Executer {

    public static void main(String[] args) throws InterruptedException {

        Counter1 counter = new Counter1();
        ExecutorService executor = Executors.newFixedThreadPool(20000);

       executor.submit(() -> {
    for (int i = 1; i <= 1000; i++) {
        counter.increment();
    }
});

executor.submit(() -> {
   
    for (int i = 1; i <= 1000; i++) {
        counter.increment();
    }
});

        // executor.shutdown();
        // executor.awaitTermination(1, TimeUnit.MINUTES);
Thread.sleep(1); // Wait for a second to allow threads to finish
        System.out.println("Count = " + counter.getCount());
    }
}