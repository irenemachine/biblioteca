import junit.framework.TestCase;

/**
 * Created with IntelliJ IDEA.
 * User: irenehaque
 * Date: 7/18/12
 * Time: 2:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class OptionTest extends TestCase {
    public void testGetDescription() {
        assertEquals("View all books", new Option("View all books").getDescription());
    }
}
