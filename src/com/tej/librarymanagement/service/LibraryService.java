package com.tej.librarymanagement.service;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import com.tej.librarymanagement.model.BookPrinter;
import com.tej.librarymanagement.comparator.PriceComparator;
import com.tej.librarymanagement.comparator.WriterComparator;
import com.tej.librarymanagement.exception.InvalidBookException;
import com.tej.librarymanagement.exception.BookNotFoundException;

import com.tej.librarymanagement.model.Book;

public class LibraryService {

     ArrayList<Book> books = new ArrayList<>();

   

      public void loadSampleData() throws InvalidBookException{
  for(int i =1;i<=500;i++){
          books.add(new Book(i, "Book_" + i, "Writer_"+i, i*5));
  }
      }
      

      public void dispalyBooks()
   {

    for(Book b1 : books){
        System.out.println(b1);
        
    }
   } 
    
   public void sortByTitle(){
    Collections.sort(books);
        System.out.println("sort by Title");

for(Book book : books){
        System.out.print(book.getTitle() + "  ");
        System.out.print(book.getPrice() + "  ");
        System.out.println(book.getWriter());
}
   }



   public void sortByPrice(){
    Collections.sort(books,new PriceComparator());
        System.out.println("sort by Price");

for(Book book : books){
        System.out.print(book.getTitle() + "  ");
        System.out.print(book.getPrice() + "  ");
        System.out.println(book.getWriter());
}
   }
   

   
           public void sortByPriceUsingStream(){
    List<Book> sortedBooks = books.stream()
            .sorted((b1, b2) -> Double.compare(b1.getPrice(), b2.getPrice()))
            .collect(Collectors.toList());
            System.out.println(sortedBooks);

}

   public void sortByWriter(){
    Collections.sort(books,new WriterComparator());
    System.out.println("sort by Writer");

for(Book book : books){
        System.out.print(book.getTitle() + "  ");
        System.out.print(book.getPrice() + "  ");
        System.out.println(book.getWriter());
}
}
public void displayTotalBooks() {
    System.out.println("Total Books : " + books.size());
}

public Book findBookByTitle(String title) throws BookNotFoundException {

    for (Book book : books) {
        if (book.getTitle().equals(title)) {
            return book;
        }
    }

    throw new BookNotFoundException("Book with title '" + title + "' not found.");
}

public void addBook(Book book) {
    books.add(book);
}

public void removeBook(String title) {

    for (int i = 0; i < books.size(); i++) {
        if (books.get(i).getTitle().equals(title)) {
            books.remove(i);
            System.out.println("Removed Book: " + title);
            return;
        }
    }

    System.out.println(title + " does not exist in the library.");
}

public void bookExists(String title) {

    for (Book book : books) {
        if (book.getTitle().equals(title)) {
            System.out.println();
            System.out.println("Book with title '" + title + "' exists in the library.");
            return;
        }
    }
System.out.println();
    System.out.println("Book with title '" + title + "' does not exist in the library.");

}


public void saveBooksToFile(){

    try(FileWriter f = new FileWriter("books.txt"))
    

{
   
    for(Book b1 : books){
      f.write(b1.toString());
        
    }
    }catch(Exception e){
        System.out.println(e.getMessage());

    }
}

Map<String,List<Book>> GBW = new HashMap<>();

//  using a for loop 
public void groupByWriter(){

for(Book book : books)
{
    String writer = book.getWriter();

        if(!GBW.containsKey(writer)){
        GBW.put(writer,new ArrayList<>());
        }

        GBW.get(writer).add(book);

}

 for(Map.Entry<String,List<Book>> entry : GBW.entrySet() ){

        System.out.println("Write : " + entry.getKey() );

        for(Book t : entry.getValue()){
        System.out.println(" " + t.getTitle());
        }
        System.out.println();
        }

   }

  // using a Stream 
 public void groupByWriterusingStream(){

Map<String,List<Book>> groupByWriter =  books.stream().    // it convert Arraylist books into stream of books so we can process it
collect(Collectors.groupingBy(Book::getWriter));  //Book::getWriter    is method reference     

// collect is stream operation that colects the elements of the stream into a collection, in 
// this case, a map where the keys are the writers amd the values are lists of books written by each writer.


if(!groupByWriter.isEmpty()){
    for(Map.Entry<String,List<Book>> entry : groupByWriter.entrySet() ){

        System.out.println("Write : " + entry.getKey() );

        for(Book t : entry.getValue()){
        System.out.println(" " + t.getTitle());
        }
        System.out.println();
        }
}

 }


public void functionalInterfaceExample() {
    BookPrinter BP = (supplier, predicate, function, consumer) -> {
        Book book = supplier.get();
        if (book != null && predicate.test(book)) {
            String result = function.apply(book);
            consumer.accept(result);
        } else {
            System.out.println("Book does not meet the criteria.");
        }
    };

    Supplier<Book> bookSupplier = () -> {
        try {
            return new Book(1, "Book_1", "Writer_1", 5);
        } catch (InvalidBookException e) {
            e.printStackTrace();
        }
        return null;
    };
    Predicate<Book> bookPredicate = (book) -> book.getPrice() > 0;
    Function<Book, String> bookFunction = (book) ->"ID: " + book.getId() + ", Title: " + book.getTitle() + ", Writer: " + book.getWriter() + ", Price: " + book.getPrice();
    Consumer<String> bookConsumer = (result) -> System.out.println(result);

    BP.processBook(bookSupplier, bookPredicate, bookFunction, bookConsumer);


}

public void partition(){
    List<Integer> num  =Arrays.asList(1,2,3,4,5,6);


Map<Boolean,List<Integer>> PN =num.stream()
.collect(Collectors.partitioningBy(n->n%2==0));
System.out.println(PN);

}
public void partitionWithSub(){
    List<Integer> num  =Arrays.asList(1,2,3,4,5,6);


Map<Boolean,Long> PN =num.stream()
.collect(Collectors.partitioningBy(n->n%2==0,Collectors.counting()));
System.out.println(PN);

}
    


 }

