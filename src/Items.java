import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: irenehaque
 * Date: 7/17/12
 * Time: 12:53 AM
 * To change this template use File | Settings | File Templates.
 */
public enum Items {

    INSTANCE;

    Book[] books = {
      new Book("Refactoring", true),
      new Book("Book2", true)
    };

    public String getBooks() {
        int i = 0;
        String bookNames = "";
        for(Book book : books) {
            i++;
            bookNames += i + ". " + book.getName() + "\n";
        }
        return bookNames;
    }
    public String reserveBook(int bookIndex) {
        if (bookIndex < books.length && books[bookIndex - 1].reserve())  {
            return "Thank You! Enjoy the book.";
        } else {
            return "Sorry we don't have that book yet.";
        }
    }
}
