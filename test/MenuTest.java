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

    public void testPrintGoodbyeMessage() throws IOException {
        menu.printGoodbyeMessage();
        verify(aUI).print(Message.GOODBYE.text());
    }

    public void testPrintOptionDescriptions() {
        menu.printOptionDescriptions();
        verify(aUI).print("0. View all books\n");
        verify(aUI).print("1. Reserve a book\n");
        verify(aUI).print("2. View all movies\n");
        verify(aUI).print("3. View movie details\n");
        verify(aUI).print("4. Check a library card\n");
        verify(aUI).print("5. Login\n");
        verify(aUI).print("6. Exit\n");
    }

    public void testSelectOptionInvalid() throws IOException {
        when(aUI.readStringInput()).thenReturn("10");
        menu.selectOption();
        verify(aUI).print("Enter an option : ");
        verify(aUI).print(Message.INVALID_INPUT.text());
    }

    public void testSelectOption() throws IOException {
        when(aUI.readStringInput()).thenReturn("4");
        menu.selectOption();
        verify(aUI).print("Enter an option : ");
        verify(aUI).print(Message.PERMISSION_DENIED.text());
    }

    public void testLogin() {
        assertEquals(menu.login(new String[]{"111-1111", "password11"}), Message.LOGIN_CONFIRMATION.text());
        assertEquals(menu.currentUser.getClass(), RegisteredUser.class);
    }

    public void testLoginWithInvalidPassword() {
        assertEquals(menu.login(new String[]{"111-1111", "notmypassword"}), Message.INVALID_LOGIN_CREDENTIALS.text());
        assertEquals(menu.currentUser.getClass(), AnonymousUser.class);
    }

    public void testLoginWithInvalidCardNumber() {
        assertEquals(menu.login(new String[]{"111-11xx", "notmypassword"}), Message.INVALID_LOGIN_CREDENTIALS.text());
        assertEquals(menu.currentUser.getClass(), AnonymousUser.class);
    }

    public void testQuit() {
        assertEquals(menu.quit(), null);
        assertFalse(menu.isOpen());
    }
}
