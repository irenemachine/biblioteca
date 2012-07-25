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
    LOGIN_CONFIRMATION(""),
    LOGOUT_CONFIRMATION(""),
    INVALID_LOGIN_CREDENTIALS(""),
    PERMISSION_DENIED ("Please talk to Librarian. Thank you.");

    private final String text;

    Message(String text) {
        this.text = text;
    }

    public String text() {
        return text;
    }
}
