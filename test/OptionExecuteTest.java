import junit.framework.TestCase;

import static org.mockito.Mockito.mock;

/**
 * Created with IntelliJ IDEA.
 * User: irenehaque
 * Date: 7/23/12
 * Time: 8:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class OptionExecuteTest extends TestCase {
    Items Items = new Items();
    OptionExecute optionExecute = new OptionExecute() { public String execute(String[] input) { return Items.getBooks(); } };

    public void testExecute() {
        assertEquals("0. Refactoring\n1. Book2\n", optionExecute.execute(null));
    }
}
