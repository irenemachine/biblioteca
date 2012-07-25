/**
 * Created with IntelliJ IDEA.
 * User: irenehaque
 * Date: 7/23/12
 * Time: 10:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class Movie extends Media {

    private String name;
    private String director;
    private String rating;

    public Movie(String aName, String aDirector, String aRating) {
        name = aName;
        director = aDirector;
        rating = aRating;
    }

    public Movie(String aName, String aDirector) {
        name = aName;
        director = aDirector;
        rating = "N/A";
    }

    public String getName() {
        return name;
    }

    public String getDirector() {
        return director;
    }

    public String getRating() {
        return rating;
    }

    public String getNameDirectorRating () {
        return name + " / " + director + " / " + rating;
    }
}
