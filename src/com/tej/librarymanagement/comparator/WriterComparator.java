package com.tej.librarymanagement.comparator;
import java.util.Comparator;
import com.tej.librarymanagement.model.Book;

public class WriterComparator implements Comparator<Book>{

    @Override
    public int compare(Book arg0, Book arg1) {
return arg0.getWriter().compareTo(arg1.getWriter());
    }
    
}
