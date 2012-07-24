/**
 * Created with IntelliJ IDEA.
 * User: irenehaque
 * Date: 7/16/12
 * Time: 12:00 AM
 * To change this template use File | Settings | File Templates.
 */
public class Menu {

    Option[] options = {
        new Option("View all books"),
        new Option("Reserve a book"),
        new Option("Check a library card")
    };

    public static String getWelcomeMessage() {
        return "Welcome to the Biblioteca";
    }

    public String getOptionDescriptions() {
        String allOptionDescriptions = "";
        int i = 0;
        for (Option option : options) {
            allOptionDescriptions += i + ". " + option.getDescription() + "\n";
            i++;
        }
        return allOptionDescriptions;
    }

    public Option getOptionByIndex(int optionIndex) {
        return options[optionIndex];
    }

}
