import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.*;
import java.io.*;


/**
 * Created with IntelliJ IDEA.
 * User: irenehaque
 * Date: 7/24/12
 * Time: 10:56 AM
 * To change this template use File | Settings | File Templates.
 */
public class UITest {
    BufferedReader aIS = mock(BufferedReader.class);
    UI UI = new UI(aIS);

    @Test
    public void testReadStringInput() throws IOException {
        when(aIS.readLine()).thenReturn("a string");
        assertEquals("a string", UI.readStringInput());
    }

}