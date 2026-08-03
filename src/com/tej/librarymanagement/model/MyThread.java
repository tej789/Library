package com.tej.librarymanagement.model;


public class MyThread extends Thread {
    private TotalBooks totalBooks;

    public MyThread(TotalBooks totalBooks) {
        this.totalBooks = totalBooks;
    }

    @Override
    public void run(){

        for(int i=0;i<1000;i++){
            totalBooks.incrementTotalBooks();
        }
    }
    
    public static void main(String[] args) throws InterruptedException {
        TotalBooks totalBooks = new TotalBooks();


   
        MyThread thread1 = new MyThread(totalBooks);
        MyThread thread2 = new MyThread(totalBooks);


        // Start both threads 
        thread1.start();
        thread2.start();

        // Wait for both threads to finish ,first thread read but before first write that second thread 
        // read it and increased the value so increament might be lost
            thread1.join();
            thread2.join();
         Thread.sleep(3000);

        System.out.println("Total Books: " + totalBooks.getTotalBooks());
    }
}  
