import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: irenehaque
 * Date: 7/25/12
 * Time: 3:11 PM
 * To change this template use File | Settings | File Templates.
 */
public class UserTest {

    User user;

    @Before
    public void setUp() {
        user = new User("myPassword");
    }

    @Test
    public void testValidPassword() {
        assertTrue(user.validatePassword("myPassword"));
    }

    @Test
    public void testInvalidPassword() {
        assertFalse(user.validatePassword("NOTmyPassword"));
    }

}
