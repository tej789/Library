package com.tej.librarymanagement;

import com.tej.librarymanagement.model.*;
import com.tej.librarymanagement.exception.BookNotFoundException;
import com.tej.librarymanagement.exception.InvalidBookException;
import com.tej.librarymanagement.service.LibraryService;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@FunctionalInterface
interface BookPrinter {
        void printBook(Supplier<Book> supplier, Predicate<Book> predicate, Function<Book, String> function,
                        Consumer<String> consumer);
}

public class Main {
        public static void main(String[] args) throws InvalidBookException, BookNotFoundException {
                // Book b = new Book(1,"qwert", "TM", 5000);
                // Library l = new Library("Charusat Library", "Nadiad");
                // Member m = new Member("Tej", 38);
                // OriginalBook o = new OriginalBook(1,"trewq", "EWQ", 2000);
                // PdfBook p = new PdfBook(2, "QWERT", "TREWQ", 199);

                 
                // System.out.println("Title: " + b.getTitle());
                // System.out.println("Writer: " + b.getWriter());
                // System.out.println("Price: " + b.getPrice());

                // System.out.println("Library: " + l.getLibName());
                // System.out.println("City: " + l.getCity());

                // System.out.println("Member Name: " + m.getMN());
                // System.out.println("ID:" + m.getID());

                // System.out.println(m.toString());
                // System.out.println(m.toString());
                // System.out.println(m.getClass());
                // System.out.println(m.MN());
                // System.out.println(m.Id());

                // for Original Copy

                // System.out.println();
                // System.out.println();
                // System.out.println("Title: " + o.getTitle());
                // System.out.println("Writer: " + o.getWriter());
                // System.out.println("Price: " + o.getPrice());
                // o.borrowBook();
                // o.returnBook();

                // // for Pdf
                // System.out.println();
                // System.out.println();
                // System.out.println("Title: " + p.getTitle());
                // System.out.println("Writer: " + p.getWriter());
                // System.out.println("Price: " + p.getPrice());
                // p.borrowBook();
                // p.returnBook();

                // we pick an interface or an abstract class here ,because if we can extends a
                // class and implements
                // an interface to a subclass but not extends 2 class becuase of multiple
                // inheritance in java that is not
                // allowed and also by this we write method declaration in interface and write
                // it in subclass to get
                // code usability

                /////////////////////////////////// day3 ////////////////////////////////

                ///////////////////////////////////////////// through an ArrayList

                // ArrayList<Book> b1 = new ArrayList<>();

                // // // // add a book
                // for(int i =1;i<=500;i++){
                // b1.add(new Book(i,"Book_" + i, "Writer_"+i, i*5));
                // }

                // String x = "Book_499";

                // search a book

                // // o(1)
                // Book t = b1.get(5);

                // System.out.println(t.getTitle());
                // System.out.println(t.getWriter());
                // System.out.println(t.getPrice());

                // o(n)
                // for(Book books : b1){

                // if(books.getTitle().equals(x)){
                // System.out.println();
                // System.out.println("Id Of " +x+" is " + books.getId());
                // System.out.println("Writer Of " +x+" is " + books.getWriter());
                // System.out.println("Price Of " +x+" is " + books.getPrice());
                // }

                // }

                // /////wrong
                // for(Book books : b1){

                // if(books.getTitle().equals(x)){
                // b1.remove(books);
                // }

                // }

                // LibraryService service = new LibraryService();

                // // remove a book
                // for (int i = b1.size() - 1; i >= 0; i--) {
                // if (b1.get(i).getTitle().equals(x)) {
                // b1.remove(i);
                // }
                // }

                // service.dispalyBooks();

                // for(Book books : b1){
                // System.out.println(books.getTitle());

                // }

                //////////////////// through an LinkedList

                // LinkedList<Book> l1 = new LinkedList<>();

                // String x = "Book_499";

                // // add

                // for(int i = 1;i<=500;i++)
                // {
                // l1.add(new Book(i, "Book_" + i, "Writer_" + i, i*2));
                // }

                // l1.addFirst(new Book(501, "qwe", "ewq", 100));

                // // search

                // for(Book books : l1){

                // if(books.getTitle().equals(x)){
                // System.out.println();
                // System.out.println("Id Of " +x+" is " + books.getId());
                // System.out.println("Writer Of " +x+" is " + books.getWriter());
                // System.out.println("Price Of " +x+" is " + books.getPrice());
                // }

                // }

                // remove
                // for (int i = l1.size() - 1; i >= 0; i--) {
                // if (l1.get(i).getTitle().equals(x)) {
                // l1.remove(i);
                // System.out.println("Removed Book: " + x);
                // }
                // }

                // for(Book books : l1){
                // System.out.println(books.getTitle());

                // }

                ////////////////// HashSet //////////////////////////////

                // HashSet<Book> h1 = new HashSet<>();
                // String x = "Book_499";

                // add a book
                // for(int i =1;i<=500;i++){
                // h1.add(new Book(i,"Book_" + i, "Writer_"+i, i*5));
                // }

                // remove a book
                // h1.removeIf(book -> book.getTitle().equals(x));

                // search

                // for(Book books : h1){

                // if(books.getTitle().equals(x)){
                // System.out.println();
                // System.out.println("Id Of " +x+" is " + books.getId());
                // System.out.println("Writer Of " +x+" is " + books.getWriter());
                // System.out.println("Price Of " +x+" is " + books.getPrice());
                // }

                // }

                // for(Book books : h1){
                // System.out.println(books);

                // }

                // so basically arraylist better for faster access with o(1) time complexity ,
                // linkedlist is better for
                // faster insertion and hashset is better for unique element

                // ArrayList<Book> b1 = new ArrayList<>();

                // // // add a book
                // for(int i =1;i<=500;i++){
                // b1.add(new Book(i,"Book_" + i, "Writer_"+i, i*5));
                // }

                // try {
                // Book c = new Book(4,null, "Tej", 7);
                // System.out.println(c);
                // } catch (IllegalArgumentException e) {
                // System.out.println("Title is empty");
                // }

                LibraryService service = new LibraryService();

                // try{
                // service.findBookByTitle("Book");
                // } catch (BookNotFoundException e) {
                // System.out.println(e.getMessage());
                // }

                service.loadSampleData();

                // service.dispalyBooks();

                //  service.sortByPrice();
                // service.sortByPriceUsingStream();
                // service.sortByTitle();
                // service.sortByWriter();

                // System.out.println(service.findBookByTitle("Book_499"));

                // Book t = new Book(501,null,"Writer_501" , 2505);

                //  service.addBook(t);

                // service.removeBook("Book_501");
                // service.dispalyBooks();
                // service.bookExists("Book_500");

                // service.saveBooksToFile();

                // service.groupByWriterusingStream();

                // service.functionalInterfaceExample();

                // service.findBookByTitle("Boo");


//                 service.partition();
// service.partitionWithSub();
        }

}
