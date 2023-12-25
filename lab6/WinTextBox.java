public class WinTextBox extends Control implements TextBox {
    private String text;
    @Override
    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public void onValueChanged() {
        System.out.println("Windows value changed");
    }
}