import junit.framework.TestCase;

/**
 * Created with IntelliJ IDEA.
 * User: irenehaque
 * Date: 7/16/12
 * Time: 4:46 PM
 * To change this template use File | Settings | File Templates.
 */
public class BookTest extends TestCase {
    public void testValidReserve() {
        assertTrue(new Book(true).reserve());
    }

    public void testInvalidReserve() {
        assertFalse(new Book(false).reserve());
    }
}
