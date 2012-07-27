import junit.framework.TestCase;

import static org.mockito.Mockito.mock;

/**
 * Created with IntelliJ IDEA.
 * User: irenehaque
 * Date: 7/18/12
 * Time: 2:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class OptionTest extends TestCase {
    Items Items = mock(Items.class);
    Option option = new Option(new String[]{"View all books"}, new OptionExecute() { public String execute(String[] input) { return Items.getBooks(); } });

    public void testGetDescription() {
        assertEquals("View all books", option.getDescription());
    }

}
