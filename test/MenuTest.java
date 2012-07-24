import junit.framework.TestCase;

/**
 * Created with IntelliJ IDEA.
 * User: irenehaque
 * Date: 7/16/12
 * Time: 11:53 AM
 * To change this template use File | Settings | File Templates.
 */
public class MenuTest extends TestCase {
    Menu menu = new Menu();

    public void testGetWelcomeMessage() throws Exception {
        assertEquals("Welcome to the Biblioteca", menu.getWelcomeMessage());
    }

    public void testGetOptionDescriptions() {
        assertEquals("0. View all books\n1. Reserve a book\n2. Check a library card\n", menu.getOptionDescriptions());
    }
}
