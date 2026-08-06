package com.tej.librarymanagement.model;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Counter2 {

    private int count = 0;

    public synchronized void increment() {
        count++;
    }

    public synchronized int getCount() {
        return count;
    }
}

public class VirtualThread {

    public static void main(String[] args) throws InterruptedException {

        Counter2 counter = new Counter2();
        ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor();

        executor.submit(() -> {
            System.out.println("Worker 1 started");
            for (int i = 1; i <= 1000; i++) {
                counter.increment();
            }
            System.out.println("Worker 1 finished");
        });

        executor.submit(() -> {
            System.out.println("Worker 2 started");
            for (int i = 1; i <= 1000; i++) {
                counter.increment();
            }
            System.out.println("Worker 2 finished");
        });

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);

        System.out.println("Count = " + counter.getCount());
    }
}