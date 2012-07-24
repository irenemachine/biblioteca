import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * User: irenehaque
 * Date: 7/18/12
 * Time: 1:29 PM
 * To change this template use File | Settings | File Templates.
 */
public class Biblioteca {

    public static void main(String[] args) throws IOException {
        start();
    }

    public static void start() throws IOException {
        Menu menu = new Menu();
        int optionIndex;
        Integer input = null;

        System.out.println(menu.getWelcomeMessage());

        try {
            System.out.println(menu.getOptionDescriptions());
            System.out.println("Enter an option : ");
            optionIndex = readIntegerInput();

            Option selectedOption = menu.getOptionByIndex(optionIndex);
            if (selectedOption.getPrompt() != null) {
               System.out.println(selectedOption.getPrompt());
               input = readIntegerInput();
            }
            System.out.println(selectedOption.getLambda().execute(input));
        } catch(Exception exception) {
            System.out.println("Invalid input. Goodbye");
        }
    }

    public static Integer readIntegerInput() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        return Integer.parseInt(input.readLine());
    }

}
