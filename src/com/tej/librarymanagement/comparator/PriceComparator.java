package com.tej.librarymanagement.comparator;

import java.util.Comparator;
import com.tej.librarymanagement.model.Book;
public class PriceComparator implements Comparator<Book>{

  @Override
    public int compare(Book arg0, Book arg1) {
return Double.compare(arg0.getPrice(),arg1.getPrice()
    );
    }
    
}
