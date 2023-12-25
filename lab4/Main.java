
public class Main {
    public static void main(String[] args) {
        Workflow workflow = new Workflow();
        VKeyboard vKeyboard = new VKeyboard(workflow);

        Key a = new Key("A");
        Key fn = new Key("Fn");
        Key f3 = new Key("F3");
        Combination combination1 = new Combination(fn.getKeyName() + "+" + f3.getKeyName());
        Combination combination2 = new Combination(a.getKeyName() + "+" + fn.getKeyName());
        vKeyboard.pressKey(a);
        vKeyboard.pressCombination(combination1);
        Key ctrl = new Key("Ctrl");
        Key alt = new Key("Alt");
        Key delete = new Key("Delete");
        vKeyboard.changeCombination(combination1, combination2);
        vKeyboard.pressCombination(combination1);
        vKeyboard.reset();
    }
}