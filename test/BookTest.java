import junit.framework.TestCase;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: irenehaque
 * Date: 7/16/12
 * Time: 4:46 PM
 * To change this template use File | Settings | File Templates.
 */
public class BookTest{
    protected Book book;

    @Before
    public void setUp() {
        book = new Book("Refactoring", true);
    }

    public void testValidReserve() throws UnavailableException {
        assertTrue(book.reserve());
    }

    @Test(expected = UnavailableException.class)
    public void testInvalidReserve() throws UnavailableException {
        book.reserve();
        book.reserve();
    }

    public void testGetName() {
        assertEquals("Refactoring", book.getName());
    }
}
