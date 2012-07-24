import junit.framework.TestCase;

/**
 * Created with IntelliJ IDEA.
 * User: irenehaque
 * Date: 7/23/12
 * Time: 8:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class LambdaTest extends TestCase {
    Lambda lambda = new Lambda() { public String execute(Integer input) { return Items.INSTANCE.getBooks(); } };

    public void testExecute() {
        assertEquals("0. Refactoring\n1. Book2\n", lambda.execute(null));
    }
}
