import junit.framework.TestCase;

/**
 * Created with IntelliJ IDEA.
 * User: irenehaque
 * Date: 7/16/12
 * Time: 4:46 PM
 * To change this template use File | Settings | File Templates.
 */
public class BookTest extends TestCase {
    protected Book book = new Book("Refactoring", true);

    public void testValidReserve() {
        assertTrue(book.reserve());
    }

    public void testInvalidReserve() {
        book.reserve();
        assertFalse(book.reserve());
    }

    public void testGetName() {
        assertEquals("Refactoring", book.getName());
    }
}
