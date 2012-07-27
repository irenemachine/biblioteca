/**
 * Created with IntelliJ IDEA.
 * User: ThoughtWorks
 * Date: 7/26/12
 * Time: 4:00 PM
 * To change this template use File | Settings | File Templates.
 */
public class AnonymousUser extends User {

    public String checkCard() {
        return Message.PERMISSION_DENIED.text();
    }
}
