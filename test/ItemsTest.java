import junit.framework.TestCase;

/**
 * Created with IntelliJ IDEA.
 * User: irenehaque
 * Date: 7/17/12
 * Time: 8:40 AM
 * To change this template use File | Settings | File Templates.
 */
public class ItemsTest extends TestCase {

    public void testReserveBook() {
        assertEquals("Thank You! Enjoy the book.", Items.INSTANCE.reserveBook(1));
        assertEquals("Sorry we don't have that book yet.", Items.INSTANCE.reserveBook(3));
    }

    public void testGetBooks() {
        assertEquals("1. Refactoring\n2. Book2\n", Items.INSTANCE.getBooks());
    }

    public void testCheckCard() {
        assertEquals("Please talk to Librarian. Thank you.", Items.INSTANCE.checkCard(215));
    }
}
