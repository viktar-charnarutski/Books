package lynda.java.lambda;

import java.util.Arrays;

import static java.util.Arrays.asList;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LambdasInCollections {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Paul", "Jane", "Michaela", "Sam");
        //way to sort prior to Java 8 lambdas
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return b.compareTo(a);
            }
        });
        //first iteration with lambda
        Collections.sort(names, (String a, String b) -> {
            return b.compareTo(a);
        });
        //now remove the return statement
        Collections.sort(names, (String a, String b) -> b.compareTo(a));

        //now remove the data types and allow the compile to infer the type
        Collections.sort(names, (a, b) -> b.compareTo(a));


        //total pages in your book collection
        Book book1 = new Book("Miss Peregrine's Home for Peculiar Children",
                "Ranson", "Riggs", 382);
        Book book2 = new Book("Harry Potter and The Sorcerers Stone",
                "JK", "Rowling", 411);
        Book book3 = new Book("The Cat in the Hat",
                "Dr", "Seuss", 45);

        List<Book> books = Arrays.asList(book1, book2, book3);
        int total = books.stream()
                .collect(Collectors.summingInt(Book::getPages));
        System.out.println(total);

        //aggregate author first names into a list
        List<String> list = books.stream()
                .map(Book::getAuthorLName)
                .collect(Collectors.toList());
        System.out.println(list);

    }
}
