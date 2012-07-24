import junit.framework.TestCase;

/**
 * Created with IntelliJ IDEA.
 * User: irenehaque
 * Date: 7/18/12
 * Time: 2:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class OptionTest extends TestCase {

    Option option = new Option("View all books", new Lambda() { public String execute(Integer input) { return Items.INSTANCE.getBooks(); } });

    public void testGetDescription() {
        assertEquals("View all books", option.getDescription());
    }

    public void testGetPrompt() {
        assertEquals(null, option.getPrompt());
    }
}
