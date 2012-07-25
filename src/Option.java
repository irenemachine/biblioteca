
/**
 * Created with IntelliJ IDEA.
 * User: irenehaque
 * Date: 7/16/12
 * Time: 7:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class Option {
    private String description;
    private OptionExecute optionExecute;
    private String prompt;

    public Option (String aDescription, OptionExecute aOptionExecute) {
        description = aDescription;
        optionExecute = aOptionExecute;
        prompt = null;
    }

    public Option (String aDescription, String aPrompt, OptionExecute aOptionExecute) {
        description = aDescription;
        optionExecute = aOptionExecute;
        prompt = aPrompt;
    }

    public String getDescription() {
        return description;
    }

    public OptionExecute getOptionExecute() {
        return optionExecute;
    }

    public String getPrompt() {
        return prompt;
    }
}
