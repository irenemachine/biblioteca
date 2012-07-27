
/**
 * Created with IntelliJ IDEA.
 * User: irenehaque
 * Date: 7/16/12
 * Time: 7:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class Option {
    private String[] textArray;
    private OptionExecute optionExecute;
    //private String prompt;

    public Option (String[] aTextArray, OptionExecute aOptionExecute) {
        textArray = aTextArray;
        optionExecute = aOptionExecute;
    }

    public String getDescription() {
        return textArray[0];
    }

    public String[] getTextArray() {
        return textArray;
    }

    public OptionExecute getOptionExecute() {
        return optionExecute;
    }

}
