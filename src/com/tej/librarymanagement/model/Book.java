package com.tej.librarymanagement.model;
import com.tej.librarymanagement.exception.InvalidBookException;
import java.util.Optional;
public class Book implements Comparable<Book>{
    private int id;
    private String title;
    private String writer;
    private double price;

    public Book(int id, String title , String writer ,double price) throws InvalidBookException{

//       if(title == null || title.isBlank()){
// throw new InvalidBookException("Title should not be empty");
//       }

this.title=Optional.ofNullable(title)
.orElseThrow((() -> new InvalidBookException("Title should not be empty")));

//       if (writer == null || writer.isBlank()) {
//     throw new InvalidBookException("Writer should not be empty");
// }
this.writer = Optional.ofNullable(writer)
.orElseThrow((() -> new InvalidBookException("Writer should not be empty")));

// if (price <= 0) {
//     throw new InvalidBookException("Price should be greater than 0");
// }

this.price = Optional.of(price)
.filter(p -> p > 0)
.orElseThrow((() -> new InvalidBookException("Price should be greater than 0")));

        this.id = id;
        this.title = title;
    this.writer = writer;
     this.price = price;
    }


    public int getId(){
      return id;
    }


public String getTitle(){
      return title;
    }

    public String getWriter(){
      return writer;
    }
 public double getPrice(){
      return price;
    }

    @Override
    public int compareTo(Book arg0) {
return this.getTitle().compareTo(arg0.getTitle());   
 }

 @Override
public String toString() {
    String x =  "\nID : " + id + "  Title : " + title + "  Writer: " + writer + "  Price : " + price;
    return x;
}
}
