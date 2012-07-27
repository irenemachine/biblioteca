import org.junit.Test;

import static junit.framework.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: ThoughtWorks
 * Date: 7/27/12
 * Time: 12:46 AM
 * To change this template use File | Settings | File Templates.
 */
public class RegisteredUserTest{
    RegisteredUser user = new RegisteredUser("cardnumber", "password");

    @Test
    public void testCheckCard() {
        assertEquals(Message.CARD_CHECK_SUCCESS.text() + user.cardNumber, user.checkCard());
    }

    @Test
    public void validatePasswordValid() {
        assertTrue(user.validatePassword("password"));
    }

    @Test
    public void validatePasswordInvalid() {
        assertFalse(user.validatePassword("xxx"));
    }
}
