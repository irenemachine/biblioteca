import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


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
    Items items = new Items();
    User currentUser;

    public Menu(UI aUI) {
        UI = aUI;
        open = true;
        currentUser = new AnonymousUser();
    }


    Option[] options = {
        new Option(new String[]{"View all books"}, new OptionExecute() {
            @Override public String execute(String[] input) {
                return items.getBooks();
            }
        }),
        new Option(new String[]{"Reserve a book", "Enter book number: "}, new OptionExecute() {
            @Override public String execute(String[] input) {
                return items.reserveBook(Integer.parseInt(input[0]));
            }
        }),
        new Option(new String[]{"View all movies"}, new OptionExecute() {
            @Override public String execute(String[] input) {
                return items.getMovies();
            }
        }),
        new Option(new String[]{"View movie details", "Enter movie number: "}, new OptionExecute() {
            @Override public String execute(String[] input) {
                return items.viewMovie(Integer.parseInt(input[0]));
            }
        }),
        new Option(new String[]{"Check a library card"}, new OptionExecute() {
            @Override public String execute(String[] input) {
                 return currentUser.checkCard();
             }
        }),

        new Option(new String[]{"Login", "Enter card number: ", "Enter password: "}, new OptionExecute() {
            @Override
            public String execute(String[] input) {
                return login(input);
            }
        }),

        new Option(new String[]{"Exit"}, new OptionExecute() {
                @Override
                public String execute(String[] input) {
                    return quit();
                }
            })
    };

    public void printWelcomeMessage() {
        UI.print(Message.HELLO.text());
    }

    public void printGoodbyeMessage() {
        UI.print(Message.GOODBYE.text());
    }

    public void printOptionDescriptions() {
        int i = 0;
        for (Option option : options) {
            UI.print(i + ". " + option.getDescription() + "\n");
            i++;
        }
    }

    public Option getOptionByIndex(int optionIndex) {
        return options[optionIndex];
    }

    public void selectOption() throws IOException {
        try {
            UI.print("Enter an option : ");
            Integer optionIndex = Integer.parseInt(UI.readStringInput());
            findAndExecuteOption(optionIndex);
        } catch(NumberFormatException exception) {
            UI.print(Message.INVALID_INPUT.text());
        } catch (ArrayIndexOutOfBoundsException exception) {
            UI.print(Message.INVALID_INPUT.text());
        }
    }

    private void findAndExecuteOption(int optionIndex) throws IOException{
        Option selectedOption = getOptionByIndex(optionIndex);
        String[] input = new String[selectedOption.getTextArray().length - 1];
        for(int i = 1; i<selectedOption.getTextArray().length; i++) {
            UI.print(selectedOption.getTextArray()[i]);
            input[i-1] = UI.readStringInput();
        }
        UI.print(selectedOption.getOptionExecute().execute(input));
    }

    public boolean isOpen() {
        return open;
    }

    public String login(String[] input) {
        RegisteredUser user = items.getRegisteredUser(input[0]);
        if (user != null && user.validatePassword(input[1])) {
        //if (user != null && user.validatePassword(input[1])) {
            options[5] =  new Option(new String[]{"Logout"}, new OptionExecute() {
                @Override
                public String execute(String[] input) {
                    return logout(input);
                }
            });
            currentUser = user;
            return Message.LOGIN_CONFIRMATION.text();
        }
        return Message.INVALID_LOGIN_CREDENTIALS.text();
    }

    public String logout(String[] input) {
        currentUser = new AnonymousUser();
        options[5] = new Option(new String[]{"Login", "Enter card number: ", "Enter password: "}, new OptionExecute() {
            @Override
            public String execute(String[] input) {
                return login(input);
            }
        });
        return Message.LOGOUT_CONFIRMATION.text();
    }

    public String quit() {
        open = false;
        return null;
    }

}
