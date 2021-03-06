import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: irenehaque
 * Date: 7/17/12
 * Time: 12:53 AM
 * To change this template use File | Settings | File Templates.
 */
public class Items {

    HashMap<String, RegisteredUser> users = new HashMap<String, RegisteredUser>();

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

    public Items() {
        users.put("111-1111", new RegisteredUser("111-1111", "password11"));
        users.put("111-1112", new RegisteredUser("111-1112", "password12"));
    }

    private String printMediaList(Media[] medias) {
        int i = 0;
        String names = "";
        for(Media m: medias) {
            names += i + ". " + m.getName() + "\n";
            i++;
        }
        return names;
    }

    public String getBooks() {
        return printMediaList(books);
    }

    public String getMovies() {
        return printMediaList(movies);
    }

    public String reserveBook(int bookIndex) {
        if (bookIndex >= books.length) {
            return Message.NO_BOOK.text();
        } else if ( books[bookIndex].isAvailable())  {
            try {
                books[bookIndex].reserve();
                return Message.RESERVE_BOOK_CONFIRMATION.text();
            } catch(UnavailableException e) {
                return Message.UNAVAILABLE_BOOK.text();
            }
        } else {
            return Message.UNAVAILABLE_BOOK.text();
        }
    }

    public String viewMovie(int movieIndex) {
        if (movieIndex < movies.length) {
            return movies[movieIndex].getNameDirectorRating();
        } else {
          return Message.NO_MOVIE.text();
        }
    }

    public RegisteredUser getRegisteredUser(String cardNumber) {
        return users.get(cardNumber);
    }

}
