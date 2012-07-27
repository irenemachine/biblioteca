
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: ThoughtWorks
 * Date: 7/27/12
 * Time: 12:45 AM
 * To change this template use File | Settings | File Templates.
 */
public class AnonymousUserTest {

    @Test
    public void testCheckCard() {
        assertEquals(Message.PERMISSION_DENIED.text(), new AnonymousUser().checkCard());
    }
}
