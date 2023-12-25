public interface VKeyboardInterface {
    public void pressKey(Key key);
    public void pressCombination(Combination combination);
    public void reset();
    public void changeCombination(Combination target, Combination newCombination);
}