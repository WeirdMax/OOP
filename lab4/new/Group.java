import java.util.List;
import java.util.Stack;

public class Group {
    private Stack<Command> commands;

    public Group(List<Command> commands) {
        this.commands = new Stack<>();
        this.commands.addAll(commands);
    }

    public void addCommand(Command command) {
        this.commands.push(command);
    }

    public void undoLastCommand() {
        for(Command command : this.commands) {
            command.undo();
        }
    }

    public void run() {
        for (Command command : this.commands) {
            command.run();
        }
    }

    public void undo() {
        this.commands.get(this.commands.size() - 1).undo();
        this.commands.pop();
    }

    public boolean isEmpty() {
        return this.commands.isEmpty();
    }

    public Stack<Command> getCommands() {
        return this.commands;
    }
}
