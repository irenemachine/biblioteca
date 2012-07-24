
/**
 * Created with IntelliJ IDEA.
 * User: irenehaque
 * Date: 7/16/12
 * Time: 7:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class Option {
    private String description;
    private Lambda lambda;

    public Option (String aDescription, Lambda aLambda) {
        description = aDescription;
        lambda = aLambda;
    }

    public String getDescription() {
        return description;
    }

    public Lambda getLambda() {
        return lambda;
    }
}
