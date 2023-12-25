
import java.io.IOException;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Map;

public class VKeyboard implements VKeyboardInterface{
    private final Workflow workflow;
    private ArrayList<Map.Entry<Key, String>> keys;
    private ArrayList<Map.Entry<Combination, String>> combinations;


    public VKeyboard(Workflow workflow) {
        this.workflow = workflow;
        this.keys = new ArrayList<>();
        this.combinations = new ArrayList<>();
    }

    public void pressKey(Key key) {
        keys.add(new AbstractMap.SimpleEntry<>(key, "pressKey(" + key.getKeyName() + ")"));
        workflow.showLastPerformedAction(getKeys());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void pressCombination(Combination combination) {
        addCombinationToCollections(combination);
        showLastPerformedAction();
        performAction(combination);
    }
    private void addCombinationToCollections(Combination combination) {
        combinations.add(new AbstractMap.SimpleEntry<>(new Combination(combination.getCombinationName()), "Combination " + combination.getCombinationName()));
        this.keys.add(new AbstractMap.SimpleEntry<>(new Key(combination.getCombinationName()), "combination '" + combination.getCombinationName() + "'"));
    }
    private void showLastPerformedAction() {
        workflow.showLastPerformedAction(getKeys());
    }
    private void performAction(Combination combination) {
        String combinationName = combination.getCombinationName();
        if (combinationName.equals("Fn+F3")) {
            volumeUp();
        } else if (combinationName.equals("Ctrl+Alt+T")) {
            openGnomeTerminal();
        } else if (combinationName.equals("Ctrl+Alt+Delete")) {
            openGnomeSystemMonitor();
        } else if (combinationName.equals("Ctrl+Z")) {
            resetAndSleep();
        }
    }
    private void volumeUp() {
        System.out.println("Volume UP");
    }
    private void openGnomeTerminal() {
        try {
            Runtime.getRuntime().exec("gnome-terminal");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private void openGnomeSystemMonitor() {
        try {
            Runtime.getRuntime().exec("gnome-system-monitor");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void resetAndSleep() {
        reset();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void reset() {
        if (!keys.isEmpty()) {
            Map.Entry<Key, String> lastAction = keys.get(keys.size() - 1);
            keys.add(new AbstractMap.SimpleEntry<>(new Key("reset"), "reset " + lastAction.getValue()));
            workflow.showLastPerformedAction(getKeys());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void changeCombination(Combination target, Combination newCombination) {
        for (int i = 0; i < combinations.size(); i++) {
            Map.Entry<Combination, String> entry = combinations.get(i);
            if (entry.getKey().getCombinationName().equals(target.getCombinationName())) {
                combinations.set(i, new AbstractMap.SimpleEntry<>(newCombination, "Combination " + newCombination.getCombinationName()));
                keys.add(new AbstractMap.SimpleEntry<>(new Key("Combination changed"), "Changed " + entry.getKey().getCombinationName() + " to " + newCombination.getCombinationName()));
                target.setCombinationName(newCombination.getCombinationName());
                workflow.showLastPerformedAction(keys);
                return;
            }
        }
        System.out.println("Can't find combination to change");
    }

    public ArrayList<Map.Entry<Key, String>> getKeys() {
        return keys;
    }
}