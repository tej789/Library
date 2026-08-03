package com.tej.librarymanagement.model;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public interface BookPrinter {
    // void printBook(Book book);
    
    void processBook(
        Supplier<Book> supplier,
        Predicate<Book> predicate,
         Function<Book, String> function,
        Consumer<String> Consumer
    );
    
}


