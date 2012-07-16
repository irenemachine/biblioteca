import junit.framework.TestCase;

/**
 * Created with IntelliJ IDEA.
 * User: irenehaque
 * Date: 7/16/12
 * Time: 11:53 AM
 * To change this template use File | Settings | File Templates.
 */
public class MenuTest extends TestCase {
    public void testGetWelcomeMessage() throws Exception {
        assertEquals("Welcome to the Biblioteca", new Menu().getWelcomeMessage());
    }
}
