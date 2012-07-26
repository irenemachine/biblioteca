/**
 * Created with IntelliJ IDEA.
 * User: irenehaque
 * Date: 7/25/12
 * Time: 7:12 AM
 * To change this template use File | Settings | File Templates.
 */
public enum Message {
    INVALID_INPUT ("Select a valid option!!"),
    HELLO ("Welcome to the Biblioteca"),
    GOODBYE ("Goodbye!"),
    UNAVAILABLE_BOOK("Sorry that book is unavailable at the moment."),
    NO_BOOK("Sorry we don't have that book yet."),
    NO_MOVIE("Sorry we don't have that movie yet"),
    RESERVE_BOOK_CONFIRMATION("Thank You! Enjoy the book."),
    LOGIN_CONFIRMATION("You successfully logged in"),
    LOGOUT_CONFIRMATION("You successfully logged out"),
    INVALID_LOGIN_CREDENTIALS("That card number or password is wrong"),
    PERMISSION_DENIED ("Please talk to Librarian. Thank you."),
    CARD_CHECK_SUCCESS ("Your card number is: ");

    private final String text;

    Message(String text) {
        this.text = text;
    }

    public String text() {
        return text;
    }
}
