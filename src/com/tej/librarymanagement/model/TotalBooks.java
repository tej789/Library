package com.tej.librarymanagement.model;


public class TotalBooks {

     int totalBooks = 0;

     // synchronized prevents race condition by synchronizing the method so that only one thread can
     //  access it at a time

     // after adding synchronized keyword in method  , only one thread is in thhis method at a time
     public synchronized void incrementTotalBooks() {
        totalBooks++;
     }
  
     // in MyThread.java file 2 threads are trying to increment the totalBooks variable thats why
     //race condition occurs and to prevent this we used synchronized keyword in increamentTotalBooks()
    // method so that only one thread can access it at time and the other thread has to wait for the first 
    // thread to finish its execution and then the second thread can access it

public int getTotalBooks(){
   return totalBooks;
}

}
