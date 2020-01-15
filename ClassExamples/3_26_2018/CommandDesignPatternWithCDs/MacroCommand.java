import lsdn.Command;
import java.util.ArrayList;

public class MacroCommand implements Command<CD> {
    
    private ArrayList<Command<CD>> commands;
    
    public MacroCommand() {
        commands = new ArrayList<Command<CD>>();
        commands.add(new IncreaseRating());
        commands.add(new Display<CD>());
    }
    
    public void execute(CD cd) {
        for (Command<CD> command : commands) {
            command.execute(cd);
        }
    }
}