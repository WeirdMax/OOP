import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        VKeyboard keyboard = new VKeyboard();
        Key key1 = new Key("X");
        Key key2 = new Key("Y");
        Key key3 = new Key("Z");
        keyboard.addCommand(key3, new StringCommand("A"));
        keyboard.addCommand(key1, new StringCommand("Hello,"));
        keyboard.addCommand(key1, new StringCommand("World!"));
        keyboard.addCommandGroup(key2, new Group(Arrays.asList(new StringCommand("Please"), new StringCommand("be"), new StringCommand("alright"))));
        keyboard.pressKey(key1);
        keyboard.pressKey(key3);
        keyboard.pressKeyTimeLong(key2, 2);
        keyboard.undoLastAction();

        keyboard.pressKey(key2);

        keyboard.remapKey(key2, key1);
        keyboard.pressKey(key1);
    }
}
