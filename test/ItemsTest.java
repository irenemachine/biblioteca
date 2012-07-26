import junit.framework.TestCase;

/**
 * Created with IntelliJ IDEA.
 * User: irenehaque
 * Date: 7/17/12
 * Time: 8:40 AM
 * To change this template use File | Settings | File Templates.
 */
public class ItemsTest extends TestCase {
    Items Items = new Items();

    public void testReserveBook() {
        assertEquals(Message.RESERVE_BOOK_CONFIRMATION.text(), Items.reserveBook(1));
        assertEquals(Message.NO_BOOK.text(), Items.reserveBook(3));
        assertEquals(Message.UNAVAILABLE_BOOK.text(), Items.reserveBook(1));
    }

    public void testGetBooks() {
        assertEquals("0. Refactoring\n1. Book2\n", Items.getBooks());
    }

    public void testViewMovie() {
        assertEquals("Happy Gilmore / Dennis Dugan / 10", Items.viewMovie(2));
    }

    public void testGetMovies() {
        assertEquals("0. movie0\n1. movie1\n2. Happy Gilmore\n3. movie3\n4. movie4\n5. movie5\n6. movie6\n7. movie7\n"
                + "8. movie8\n9. movie9\n10. movie10\n11. movie11\n12. movie12\n13. movie13\n14. movie14\n", Items.getMovies());
    }
}
