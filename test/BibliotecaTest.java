import junit.framework.TestCase;

import java.io.IOException;

import static org.mockito.Mockito.*;

/**
 * Created with IntelliJ IDEA.
 * User: irenehaque
 * Date: 7/18/12
 * Time: 2:17 PM
 * To change this template use File | Settings | File Templates.
 */
public class BibliotecaTest extends TestCase {
    Menu menu = mock(Menu.class);
    Biblioteca b = new Biblioteca(menu);

    public void testStart() throws IOException {
        when(menu.isOpen()).thenReturn(false);
        b.start();
        verify(menu).printWelcomeMessage();
        verify(menu).printGoodbyeMessage();
    }
}
