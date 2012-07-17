/**
 * Created with IntelliJ IDEA.
 * User: irenehaque
 * Date: 7/16/12
 * Time: 4:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class Book {
    private String name;
    private boolean available;

    public Book(String aName, boolean isAvailable) {
        name = aName;
        available = isAvailable;
    }

    public boolean reserve() {
        if (available) {
            available = false;
            return true;
        }
        else {
            return false;
        }
    }

    public String getName() {
        return name;
    }
}
