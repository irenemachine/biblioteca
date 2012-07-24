import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.
 * User: irenehaque
 * Date: 7/16/12
 * Time: 12:00 AM
 * To change this template use File | Settings | File Templates.
 */
public class Menu {
    UI UI;
    boolean open;

    public Menu() {
        UI = new UI(new BufferedReader(new InputStreamReader(System.in)));
        open = true;
    }

    public Menu(UI aUI) {
        UI = aUI;
        open = true;
    }

    Option[] options = {
        new Option("View all books", new Lambda() {
            @Override public String execute(Integer input) {
                return Items.INSTANCE.getBooks();
            }
        }),
        new Option("Reserve a book", "Enter book number: ", new Lambda() {
            @Override public String execute(Integer input) {
                return Items.INSTANCE.reserveBook(input);
            }
        }),
        new Option("View all movies", new Lambda() {
            @Override public String execute(Integer input) {
                return Items.INSTANCE.getMovies();
            }
        }),
        new Option("View movie details", "Enter movie number: ", new Lambda () {
            @Override public String execute(Integer input) {
                return Items.INSTANCE.viewMovie(input);
            }
        }),
        new Option("Check a library card", "Enter card number: ", new Lambda() {
            @Override public String execute(Integer input) {
                 return Items.INSTANCE.checkCard(input);
             }
        }),
    };

    public void printWelcomeMessage() {
        UI.print("Welcome to the Biblioteca");
    }

    public void printOptionDescriptions() {
        int i = 0;
        for (Option option : options) {
            UI.print(i + ". " + option.getDescription() + "\n");
            i++;
        }
        UI.print(i + ". Exit");
    }

    public Option getOptionByIndex(int optionIndex) {
        return options[optionIndex];
    }

    public void selectOption() {
        try {
            UI.print("Enter an option : ");
            Integer optionIndex = UI.readIntegerInput();
            if(optionIndex == options.length) {
                open = false;
            } else {
                findAndExecuteOption(optionIndex);
            }
        } catch(Exception exception) {
            UI.print("Select a valid option!!");
        }
    }

    private void findAndExecuteOption(int optionIndex) {
        Integer input = null;
        Option selectedOption = getOptionByIndex(optionIndex);
        if (selectedOption.getPrompt() != null) {
            UI.print(selectedOption.getPrompt());
            try {
                input = UI.readIntegerInput();
            } catch(Exception exception) {
                UI.print("Select a valid option!!");
            }
        }
        UI.print(selectedOption.getLambda().execute(input));
    }

    public boolean isOpen() {
        return open;
    }

    public void printGoodbyeMessage() {
        UI.print("Goodbye!");
    }

}
