package com.tej.librarymanagement.model;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Executor {
   public static void main(String[] args){
    
    TotalBooks totalBooks = new TotalBooks();
    ExecutorService executorService = Executors.newFixedThreadPool(2);

    executorService.execute((()->{
        for(int i=0;i<2000;i++){
            totalBooks.incrementTotalBooks();
        }
    }));


    executorService.execute((()->{
        for(int i=0;i<1000;i++){
            totalBooks.incrementTotalBooks();
        }
    }));

    executorService.shutdown();


    // to remove race condition we added this section
    if(!executorService.isTerminated()){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    System.out.println("Total Books: "+ totalBooks);
   }




}
