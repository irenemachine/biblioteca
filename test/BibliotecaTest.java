import junit.framework.TestCase;
import sun.net.idn.StringPrep;

import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * User: irenehaque
 * Date: 7/18/12
 * Time: 2:17 PM
 * To change this template use File | Settings | File Templates.
 */
public class BibliotecaTest extends TestCase {

    protected void fakeInput(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    public void testReadIntegerInput() {
        fakeInput("1");
        try {
            assertEquals((Integer)1, Biblioteca.readIntegerInput());
        } catch (Exception e) {}
    }
}
