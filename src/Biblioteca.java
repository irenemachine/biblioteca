import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * User: irenehaque
 * Date: 7/18/12
 * Time: 1:29 PM
 * To change this template use File | Settings | File Templates.
 */
public class Biblioteca {

    Menu menu;

    public static void main(String[] args) throws IOException {
        UI UI = new UI(new BufferedReader(new InputStreamReader(System.in)));
        Menu menu = new Menu(UI);
        Biblioteca b = new Biblioteca(menu);
        b.start();
    }

    public Biblioteca(Menu aMenu) {
        menu = aMenu;
    }

    public void start() throws IOException {
        menu.printWelcomeMessage();
        while(menu.isOpen()) {
          menu.printOptionDescriptions();
          menu.selectOption();
        }
        menu.printGoodbyeMessage();
    }
}
