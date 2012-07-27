/**
 * Created with IntelliJ IDEA.
 * User: ThoughtWorks
 * Date: 7/26/12
 * Time: 3:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class RegisteredUser extends User {

    public String cardNumber;
    private String password;

    public RegisteredUser(String aCardNumber, String aPassword) {
        cardNumber = aCardNumber;
        password = aPassword;
    }

    public boolean validatePassword(String aPassword) {
        return aPassword.equals(password);
    }

    public String checkCard() {
        return Message.CARD_CHECK_SUCCESS.text() + cardNumber;
    }
}
