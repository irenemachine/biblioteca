import junit.framework.TestCase;

import java.io.IOException;
import java.lang.reflect.Method;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


/**
 * Created with IntelliJ IDEA.
 * User: irenehaque
 * Date: 7/16/12
 * Time: 11:53 AM
 * To change this template use File | Settings | File Templates.
 */
public class MenuTest extends TestCase {
    private final UI aUI = mock(UI.class);
    Menu menu = new Menu(aUI);

    public void testPrintWelcomeMessage() throws Exception {
        menu.printWelcomeMessage();
        verify(aUI).print("Welcome to the Biblioteca");
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
        verify(aUI).print("Please talk to Librarian. Thank you.");
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
        verify(aUI).print("Select a valid option!!");
    }

    public void testPrintGoodbyeMessage() throws IOException {
        menu.printGoodbyeMessage();
        verify(aUI).print("Goodbye!");
    }
}
