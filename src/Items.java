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

    Movie[] movies = {
      new Movie("movie0", "director 0"),
      new Movie("movie1", "director 1"),
      new Movie("Happy Gilmore", "Dennis Dugan", "10"),
      new Movie("movie3", "director 3", "3"),
      new Movie("movie4", "director 4", "4"),
      new Movie("movie5", "director 5", "5"),
      new Movie("movie6", "director 6", "6"),
      new Movie("movie7", "director 7", "7"),
      new Movie("movie8", "director 8", "8"),
      new Movie("movie9", "director 9", "9"),
      new Movie("movie10", "director 10", "10"),
      new Movie("movie11", "director 11", "11"),
      new Movie("movie12", "director 12", "12"),
      new Movie("movie13", "director 13", "13"),
      new Movie("movie14", "director 14", "14")
    };

    public String getBooks() {
        int i = 0;
        String bookNames = "";
        for(Book book : books) {
            bookNames += i + ". " + book.getName() + "\n";
            i++;
        }
        return bookNames;
    }
    public String reserveBook(int bookIndex) {
        if (bookIndex < books.length && books[bookIndex].reserve())  {
            return "Thank You! Enjoy the book.";
        } else {
            return "Sorry we don't have that book yet.";
        }
    }

    public String checkCard(int cardNumber) {
        return "Please talk to Librarian. Thank you.";
    }

    public String viewMovie(int movieIndex) {
        if (movieIndex < movies.length) {
            return movies[movieIndex].getNameDirectorRating();
        } else {
          return "Sorry we don't have that movie yet.";
        }
    }

    public String getMovies() {
        int i = 0;
        String movieNames = "";
        for(Movie movie : movies) {
            movieNames += i + ". " + movie.getName() + "\n";
            i++;
        }
        return movieNames;
    }
}
