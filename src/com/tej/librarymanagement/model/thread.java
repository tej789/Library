package com.tej.librarymanagement.model;

class Counter {
    int count = 0;

    public synchronized  void increment() {
        count++;
    }
    public synchronized int getCount() {
        return count;
    }
}



class thread extends Thread {

    private Counter counter;

    public thread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {

        while(true){
            System.out.println("Thread " + Thread.currentThread().getName() + " is running");
            counter.increment();
        }
    }

    public static void main(String[] args) throws Exception {

        Counter counter = new Counter();

        thread t1 = new thread(counter);
        thread t2 = new thread(counter);

        t1.start();
        t2.start();

        // t1.join();
        // t2.join();

        System.out.println("Count = " + counter.getCount());
    }
}