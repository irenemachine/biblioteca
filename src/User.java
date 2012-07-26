/**
 * Created with IntelliJ IDEA.
 * User: irenehaque
 * Date: 7/25/12
 * Time: 3:09 PM
 * To change this template use File | Settings | File Templates.
 */
public class User {

    private String password;

    public User(String aPassword) {
        password = aPassword;
    }

    public boolean validatePassword(String aPassword) {
        return aPassword.equals(password);
    }
}
