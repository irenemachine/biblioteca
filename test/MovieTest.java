import junit.framework.TestCase;

/**
 * Created with IntelliJ IDEA.
 * User: irenehaque
 * Date: 7/23/12
 * Time: 10:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class MovieTest extends TestCase {
    Movie movie = new Movie("Happy Gilmore", "Dennis Dugan", "10");

    public void testGetName() {
        assertEquals("Happy Gilmore", movie.getName());
    }

    public void testGetDirector() {
        assertEquals("Dennis Dugan", movie.getDirector());
    }

    public void testGetRating() {
        assertEquals("10", movie.getRating());
    }

    public void testGetNullRating() {
        assertEquals("N/A", new Movie("name", "director").getRating());
    }
}
