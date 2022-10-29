import library.Book;
import library.Library;

import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        Library library = new Library();
        List<Book> books = List.of(
                new Book(3, "Polowanie na Czerwony Październik"),
                new Book(2, "Czas Patriotów"),
                new Book(1, "Cardiovascular Biomechanics"),
                new Book(4, "Hands on Julia Programming"),
                new Book(6, "Math for programmers"),
                new Book(5, "Deep Learning for Biometrics")
        );
        System.out.println("Created " + Book.getCounter() + " books.\n");

        // Adding books to library.
        for (var book : books) {
            library.add(book);
        }

        // Adding book that already exist in library.
        library.add(books.get(rand.nextInt(Book.getCounter())));

        // Printing library
        System.out.println("Library:");
        library.print();
        System.out.println();

        // Searching book
        Book searchedBook = library.findBookById(rand.nextInt(Book.getCounter()));
        System.out.println("Searched book: '" + searchedBook + "'.");
    }
}
