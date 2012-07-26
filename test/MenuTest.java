import junit.framework.TestCase;
import java.io.IOException;
import static org.mockito.Mockito.*;

/**
 * Created with IntelliJ IDEA.
 * User: irenehaque
 * Date: 7/16/12
 * Time: 11:53 AM
 * To change this template use File | Settings | File Templates.
 */
public class MenuTest extends TestCase {
    private final UI aUI = mock(UI.class);
    Menu menu;

    public void setUp() {
        menu = new Menu(aUI);
    }
    public void testPrintWelcomeMessage() throws IOException {
        menu.printWelcomeMessage();
        verify(aUI).print(Message.HELLO.text());
    }

    public void testPrintOptionDescriptions() {
        menu.printOptionDescriptions();
        verify(aUI).print("0. View all books\n");
        verify(aUI).print("1. Reserve a book\n");
        verify(aUI).print("2. View all movies\n");
        verify(aUI).print("3. View movie details\n");
        verify(aUI).print("4. Check a library card\n");
        verify(aUI).print("5. Exit");
    }

    public void testSelectOption() throws IOException {
        when(aUI.readIntegerInput()).thenReturn(4);
        menu.selectOption();
        verify(aUI).print("Enter an option : ");
        verify(aUI).print(Message.PERMISSION_DENIED.text());
    }

    public void testSelectOptionQuit() throws IOException {
        when(aUI.readIntegerInput()).thenReturn(5);
        menu.selectOption();
        verify(aUI).print("Enter an option : ");
        assertFalse(menu.isOpen());
    }

    public void testSelectOptionInvalid() throws IOException {
        when(aUI.readIntegerInput()).thenReturn(10);
        menu.selectOption();
        verify(aUI).print("Enter an option : ");
        verify(aUI).print(Message.INVALID_INPUT.text());
    }

    public void testPrintGoodbyeMessage() throws IOException {
        menu.printGoodbyeMessage();
        verify(aUI).print(Message.GOODBYE.text());
    }

    public void testLoginWithValidCredentials() throws IOException{
        when(aUI.readStringInput()).thenReturn("111-1111", "password11");
        assertTrue(menu.login());
        verify(aUI).print("Please enter cardnumber: ");
        verify(aUI).print("Please enter password: ");
    }

    public void testLoginWithInvalidCredentials() throws IOException{
        when(aUI.readStringInput()).thenReturn("111-1111", "notapassword");
        assertFalse(menu.login());
        verify(aUI).print("Please enter cardnumber: ");
        verify(aUI).print("Please enter password: ");
    }

    public void testLogout(){
        menu.logout();
        assertNull(menu.currentUser);
    }

    public void testLoginOrOut() throws IOException {
        Menu spy = spy(menu);
        when(spy.login()).thenReturn(true);
         //why is this failing?
         //how to stub an actual object?
        spy.loginOrOut();
        verify(aUI).print(Message.LOGIN_CONFIRMATION.text());
        spy.loginOrOut();
        verify(aUI).print(Message.LOGOUT_CONFIRMATION.text());
        spy.loginOrOut();
        verify(aUI).print(Message.INVALID_LOGIN_CREDENTIALS.text());
    }

    public void testCheckCardLoggedIn() throws IOException{
        when(aUI.readStringInput()).thenReturn("111-1111", "password11");
        menu.login();
        assertEquals(menu.checkCard(), Message.CARD_CHECK_SUCCESS.text() + "111-1111");
    }

    public void testCheckCardLoggedOut() {
        assertEquals(menu.checkCard(), Message.PERMISSION_DENIED.text());
    }
}
