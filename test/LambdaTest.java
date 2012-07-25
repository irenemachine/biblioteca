import junit.framework.TestCase;

import static org.mockito.Mockito.mock;

/**
 * Created with IntelliJ IDEA.
 * User: irenehaque
 * Date: 7/23/12
 * Time: 8:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class LambdaTest extends TestCase {
    Items Items = new Items();
    Lambda lambda = new Lambda() { public String execute(Integer input) { return Items.getBooks(); } };

    public void testExecute() {
        assertEquals("0. Refactoring\n1. Book2\n", lambda.execute(null));
    }
}
