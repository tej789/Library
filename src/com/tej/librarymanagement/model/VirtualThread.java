package com.tej.librarymanagement.model;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Counter2 {

    int count = 0;

    public synchronized void increment() {
        count++;
    }
}

public class VirtualThread {

    public static void main(String[] args) throws InterruptedException {

        Counter2 counter = new Counter2();
        ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()  ;

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

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);

        System.out.println("Count = " + counter.count);
    }
}