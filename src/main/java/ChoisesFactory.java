import java.util.HashMap;
import java.util.Map;

public class ChoisesFactory {

    private static final Map<String,Command> allCommands;

    static {

        allCommands = new HashMap<>();

        allCommands.put("add", new Add());
        allCommands.put("delete", new Delete());
        allCommands.put("edit", new Edit());
    }

    public static Command getCommand(String commandName){
        Command StartCommand = allCommands.get(commandName);
        return StartCommand;
    }
}
