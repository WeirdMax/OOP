import java.util.*;
import java.util.concurrent.TimeUnit;

public class VKeyboard {
    private Stack<Group> stack;
    private Map<Key, Group> keyboard;
    private Map<Key, Key> keyMappings;

    public VKeyboard() {
        this.stack = new Stack<>();
        this.keyboard = new HashMap<>();
        this.keyMappings = new HashMap<>();
    }

    public void pressKey(Key key) {
        this.keyboard.get(getRemappedKey(key)).run();
        this.stack.push(this.keyboard.get(getRemappedKey(key)));
    }

    public void pressKeyTimeLong(Key key, int time) throws InterruptedException {
        TimeUnit.SECONDS.sleep(time);
        this.keyboard.get(getRemappedKey(key)).run();
        this.stack.push(this.keyboard.get(getRemappedKey(key)));
    }

    public boolean undoLastAction() {
        if (!this.stack.isEmpty()) {
            this.stack.get(this.stack.size() - 1).undo();
            this.stack.pop();
            return true;
        }
        return false;
    }

    public void remapKey(Key originalKey, Key newKey) {
        keyMappings.put(originalKey, newKey);
        Group groupCommandText = this.keyboard.get(originalKey);
        this.keyboard.remove(originalKey);
        this.keyboard.put(newKey, groupCommandText);
    }

    public Key getRemappedKey(Key originalKey) {
        if (keyMappings.containsKey(originalKey)) {
            return keyMappings.get(originalKey);
        }
        return originalKey;
    }

    public void addCommand(Key key, Command command)
    {
        if (this.keyboard.containsKey(getRemappedKey(key))) {
            this.keyboard.get(getRemappedKey(key)).addCommand(command);
            return;
        }
        this.keyboard.put(key, new Group(Collections.singletonList(command)));
    }

    public void addCommandGroup(Key key, Group groupCommand) {
        if (this.keyboard.containsKey(getRemappedKey(key))) {
            for (Command command : groupCommand.getCommands()) {
                this.keyboard.get(getRemappedKey(key)).addCommand(command);
            }
            return;
        }
        this.keyboard.put(getRemappedKey(key), groupCommand);
    }

    public void undoCommand(Key key) {
        if(this.keyboard.containsKey(getRemappedKey(key))) {
            this.keyboard.get(getRemappedKey(key)).undo();
            if (this.keyboard.get(getRemappedKey(key)).isEmpty()) {
                this.keyboard.remove(getRemappedKey(key));
            }
        }
    }

}
