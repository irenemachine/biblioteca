import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.
 * User: irenehaque
 * Date: 7/24/12
 * Time: 9:54 AM
 * To change this template use File | Settings | File Templates.
 */
public class UI {

    BufferedReader input;

    public UI(BufferedReader bufferedReader) {
        input = bufferedReader;
    }

    public String readStringInput() throws IOException {
        return input.readLine();
    }

    public void print(String string) {
        System.out.println(string);
    }
}