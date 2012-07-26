import java.io.BufferedReader;
import java.io.IOException;
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
    Items Items = new Items();
    String currentUser = null;

    public Menu(UI aUI) {
        UI = aUI;
        open = true;
    }

    Option[] options = {
        new Option("View all books", new OptionExecute() {
            @Override public String execute(Integer input) {
                return Items.getBooks();
            }
        }),
        new Option("Reserve a book", "Enter book number: ", new OptionExecute() {
            @Override public String execute(Integer input) {
                return Items.reserveBook(input);
            }
        }),
        new Option("View all movies", new OptionExecute() {
            @Override public String execute(Integer input) {
                return Items.getMovies();
            }
        }),
        new Option("View movie details", "Enter movie number: ", new OptionExecute() {
            @Override public String execute(Integer input) {
                return Items.viewMovie(input);
            }
        }),
        new Option("Check a library card", "Enter card number: ", new OptionExecute() {
            @Override public String execute(Integer input) {
                 return checkCard();
             }
        })
    };

    public void printWelcomeMessage() {
        UI.print(Message.HELLO.text());
    }

    public void printOptionDescriptions() {
        int i = 0;
        for (Option option : options) {
            UI.print(i + ". " + option.getDescription() + "\n");
            i++;
        }
        UI.print(i + ". Exit");
        UI.print((i+1) + ". " + loginOutOptionText());
    }

    public Option getOptionByIndex(int optionIndex) {
        return options[optionIndex];
    }

    public String loginOrOut() throws IOException {
        if(currentUser != null) {
            logout();
            return Message.LOGOUT_CONFIRMATION.text();
        } else {
            if (login()) {
                return Message.LOGIN_CONFIRMATION.text();
            } else {
                return Message.INVALID_LOGIN_CREDENTIALS.text();
            }
        }
    }
    public void selectOption() throws IOException {
        try {
            UI.print("Enter an option : ");
            Integer optionIndex = UI.readIntegerInput();
            if(optionIndex == options.length) {
                open = false;
            } else if (optionIndex == options.length + 1) {
                UI.print(loginOrOut());
            }
            else {
                findAndExecuteOption(optionIndex);
            }
        } catch(NumberFormatException exception) {
            UI.print(Message.INVALID_INPUT.text());
        } catch (ArrayIndexOutOfBoundsException exception) {
            UI.print(Message.INVALID_INPUT.text());
        }
    }

    private void findAndExecuteOption(int optionIndex) throws IOException{
        Integer input = null;
        Option selectedOption = getOptionByIndex(optionIndex);
        if (selectedOption.getPrompt() != null) {
            UI.print(selectedOption.getPrompt());
            try {
                input = UI.readIntegerInput();
            } catch (NumberFormatException exception) {
                UI.print(Message.INVALID_INPUT.text());
            }
        }
        UI.print(selectedOption.getOptionExecute().execute(input));
    }

    public boolean isOpen() {
        return open;
    }

    public void printGoodbyeMessage() {
        UI.print(Message.GOODBYE.text());
    }

    public String loginOutOptionText() {
        if (currentUser == null) {
            return "Login";
        } else {
            return "Logout";
        }
    }

    public void logout() {
        currentUser = null;
    }

    public boolean login() throws IOException{
        UI.print("Please enter cardnumber: ");
        String cardNumber = UI.readStringInput();
        UI.print("Please enter password: ");
        String password = UI.readStringInput();
        User user = Items.getUser(cardNumber);
        if (user != null) {
            if(user.validatePassword(password)) {
            currentUser = cardNumber;
            return true;
            }
        }
        return false;
    }

    public String checkCard() {
        if(currentUser==null) {
            return Message.PERMISSION_DENIED.text();
        } else {
            return Message.CARD_CHECK_SUCCESS.text() + currentUser;
        }
    }

}
